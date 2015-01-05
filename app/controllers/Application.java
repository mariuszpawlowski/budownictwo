package controllers;

import play.*;
import play.data.validation.Required;
import play.db.jpa.JPA;
import play.db.jpa.GenericModel.JPAQuery;
import play.db.jpa.JPABase;
import play.mvc.*;

import geo.google.GeoAddressStandardizer;
import geo.google.GeoException;
import geo.google.datamodel.GeoAddress;
import geo.google.datamodel.GeoCoordinate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;

import controllers.utils.ApplicationUtils;
import controllers.utils.BuildingComparator;


import models.*;

public class Application extends Controller {
	
	private static double LATITUDE_OFFSET = 0.25;  // 0,25 = 30km
	private static double LONGITUDE_OFFSET = 0.5;  // 0,50 = 30 km

    public static void index() {
    	
    	Set<String> expressions = new HashSet<String>();
    	Set<String> cities = new HashSet<String>();
    	Set<String> lines = new HashSet<String>();
    	JPAQuery result = null;
    	
    	// get expressions
    	result = Expression.find("select e from Expression e");
    	List<Expression> expressionResult = result.fetch();
    	for (Expression expr : expressionResult){
    		expressions.add(expr.expression);
    	}
    	
    	result = Expression.find("select b from Building b");
    	List<Building> buildingResult = result.fetch();
    	for (Building building : buildingResult){
    		expressions.add(building.expression);
    	}
    	
    	result = Expression.find("select t from TextExpression t");
    	List<TextExpression> textExpressionResult = result.fetch();
    	for (TextExpression textExpression : textExpressionResult){
    		expressions.add(textExpression.expression);
    	}
    	
    	result = DictionaryColloquialExpression.find("select d from DictionaryColloquialExpression d");
    	List<DictionaryColloquialExpression> dceList = result.fetch();
    	for (DictionaryColloquialExpression dce : dceList){
    		expressions.add(dce.expression);
    		expressions.add(dce.synonym_expression);
    	}
    	
    	
    	StringBuffer expressionsStringBuffer = new StringBuffer();
    	for (String s : expressions){
    		expressionsStringBuffer.append(s + ";");
    	}
    	
    	String expressionsData = expressionsStringBuffer.toString();
    	    	
    	// get lines and cities
    	result = Company.find("select c from Company c");
    	List<Company> companyList = result.fetch();
    	for (Company c : companyList){
    		cities.add(c.city);
    		cities.add(c.province);
    		lines.add(c.line);
    	}
    	
    	result = DictionaryColloquialExpressionsLine.find("select d from DictionaryColloquialExpressionsLine d");
    	List<DictionaryColloquialExpressionsLine> dcelList = result.fetch();
    	for (DictionaryColloquialExpressionsLine dce : dcelList){
    		lines.add(dce.expression);
    		lines.add(dce.synonym_expression);
    	}
    	
    	StringBuffer citiesStringBuffer = new StringBuffer();
    	for (String s : cities){
    		citiesStringBuffer.append(s + ";");
    	}
    	
    	StringBuffer linesStringBuffer = new StringBuffer();
    	for (String s : lines){
    		linesStringBuffer.append(s + ";");
    	}
    	
    	String citiesData = citiesStringBuffer.toString();
    	String linesData = linesStringBuffer.toString();
    	    	
        render(expressionsData, citiesData, linesData);
    }
    
    public static void searchCompany(@Required String service, @Required String where) {
    	
    	List<Company> resultCompany = new ArrayList<Company>();
    	List<Company> resultCompanyNear = new ArrayList<Company>();
    	JPAQuery result = null; 
    	String headerStyle = "";
    	
    	if (StringUtils.isNotEmpty(service) && StringUtils.isNotEmpty(where)){
    		result = Company.find("select c from Company c where c.city = ? and c.line = ?", where, service);	
    	} 
    	
    	if (result != null){
    		resultCompany = result.fetch();
    	}
    	
    	// find synonym value in companies
    	if (resultCompany.size() == 0){ 
        	result = DictionaryColloquialExpressionsLine.find("synonym_expression", service);
        	List<DictionaryColloquialExpressionsLine> synonymResult = result.fetch();
        	for (DictionaryColloquialExpressionsLine colloquialExpression : synonymResult){
        		String expr = colloquialExpression.expression;
        		result = Company.find("select c from Company c where c.city = ? and c.line = ?", where, expr);	
        		List<Company> fromSynonym = result.fetch();
        		resultCompany.addAll(fromSynonym);
        	}
        	
        }
    	
    	if (resultCompany.size() == 0) { // search voivodship
        	
    		if (StringUtils.isNotEmpty(service) && StringUtils.isNotEmpty(where)){
        		result = Company.find("select c from Company c where c.province = ? and c.line = ?", where, service);	
        	} 
        	
        	if (result != null){
        		resultCompany = result.fetch();
        	}
        	
        	// find synonym value in companies
        	if (resultCompany.size() == 0){ 
            	result = DictionaryColloquialExpressionsLine.find("synonym_expression", service);
            	List<DictionaryColloquialExpressionsLine> synonymResult = result.fetch();
            	for (DictionaryColloquialExpressionsLine colloquialExpression : synonymResult){
            		String expr = colloquialExpression.expression;
            		result = Company.find("select c from Company c where c.province = ? and c.line = ?", where, expr);	
            		List<Company> fromSynonym = result.fetch();
            		resultCompany.addAll(fromSynonym);
            	}
            	
            }
    	}
    	
    	if (resultCompany.size() == 0) { // not found any
    		if (StringUtils.isNotEmpty(service) && StringUtils.isNotEmpty(where)){
    			GeoAddressStandardizer st = new GeoAddressStandardizer("AABBCC");
    			try {
    				GeoCoordinate coordinates = st.standardizeToGeoCoordinate(where);
    				double latitude = coordinates.getLatitude();
    				double longitude = coordinates.getLongitude();
    				
    				String latitudeFrom = String.valueOf(latitude - LATITUDE_OFFSET);
    				String latitudeTo = String.valueOf(latitude + LATITUDE_OFFSET);
    				String longitudeFrom = String.valueOf(longitude - LONGITUDE_OFFSET);
    				String longitudeTo = String.valueOf(longitude + LONGITUDE_OFFSET);
    				
    				result = Company.find("select c from Company c where c.latitude > ? and c.latitude < ? and c.longitude > ? and c.longitude < ? and c.line = ?", 
    						latitudeFrom, latitudeTo, longitudeFrom, longitudeTo, service);	
    				
    				if (result != null){
    					resultCompanyNear = result.fetch();
    					
    					if (resultCompanyNear.size() == 0){
    						// find synonym value in companies
    			            	result = DictionaryColloquialExpressionsLine.find("synonym_expression", service);
    			            	List<DictionaryColloquialExpressionsLine> synonymResult = result.fetch();
    			            	for (DictionaryColloquialExpressionsLine colloquialExpression : synonymResult){
    			            		String expr = colloquialExpression.expression;
    			            		result = Company.find("select c from Company c where c.latitude > ? and c.latitude < ? and c.longitude > ? and c.longitude < ? and c.line = ?", 
    			    						latitudeFrom, latitudeTo, longitudeFrom, longitudeTo, expr);		
    			            		List<Company> fromSynonym = result.fetch();
    			            		resultCompany.addAll(fromSynonym);
    			            	}	
    					}
    		    	}
    			} catch (GeoException e) {
    				e.printStackTrace();
    			}
    			
    		}
    		
    		
    	}
    	

    	
    	int index = 1;
    	for (Company company : resultCompany){
    		company.index = index;
    		company.companyName = company.companyName.replaceAll("\n", "");
    		company.companyName = company.companyName.replaceAll("\r", "");
    		index++;
    	}
    	
    	
    	for (Company company : resultCompanyNear){
    		company.index = index;
    		company.companyName = company.companyName.replaceAll("\n", "");
    		company.companyName = company.companyName.replaceAll("\r", "");
    		index++;
    	}
    	
    	headerStyle = ApplicationUtils.getColumnHeaderStyle(resultCompany, resultCompanyNear);

    	String whereMapCenter = "";
    	if (resultCompany != null && resultCompany.size() > 0){
    		whereMapCenter = resultCompany.get(0).city;
    	} else if (resultCompanyNear != null && resultCompanyNear.size() > 0){
    		whereMapCenter = resultCompanyNear.get(0).city;
    	}

    	
    	
        render(service, where, resultCompany, resultCompanyNear, headerStyle, whereMapCenter);
    }
    
    public static void searchExpression(@Required String expression) throws UnsupportedEncodingException{
    	if(validation.hasErrors()) {
            flash.error("Proszę wpisać wyrażenie");
            index();
        }
    	
    	
    	
    	List<Expression> resultExpression = new ArrayList<Expression>();
    	List<Building> resultBuilding = new ArrayList<Building>();
    	List<TextExpression> resultTextExpression= new ArrayList<TextExpression>();
    	String resultExpressionDefinition = "";
    	String resultBuildingDefinition = "";
    	String resultTextExpressionDefinition = "";
    	boolean showWtb = true;
    	// try to find expression directly first in expression
        
        JPAQuery result = Expression.find("expression", expression);
        resultExpression = result.fetch();
        
        // if not found, user entered synonym
        if (resultExpression.size() == 0){ 
        	result = DictionaryColloquialExpression.find("synonym_expression", expression);
        	List<DictionaryColloquialExpression> synonymResult = result.fetch();
        	for (DictionaryColloquialExpression colloquialExpression : synonymResult){
        		String expr = colloquialExpression.expression;
        		result = Expression.find("expression", expr);
        		List<Expression> fromSynonym = result.fetch();
        		resultExpression.addAll(fromSynonym);
        	}
        	
        }
        
        if (resultExpression.size() > 0){
        	resultExpressionDefinition = resultExpression.get(0).definition;
        }
    	
    	// then in buildings
    	result = Building.find("expression", expression);
    	resultBuilding = result.fetch();
    	
    	// find synonym value in buildings
    	if (resultBuilding.size() == 0){ 
        	result = DictionaryColloquialExpression.find("synonym_expression", expression);
        	List<DictionaryColloquialExpression> synonymResult = result.fetch();
        	for (DictionaryColloquialExpression colloquialExpression : synonymResult){
        		String expr = colloquialExpression.expression;
        		result = Building.find("expression", expr);
        		List<Building> fromSynonym = result.fetch();
        		resultBuilding.addAll(fromSynonym);
        	}
        	
        }
    	
    	for (Building b : resultBuilding){
    		if ( (b.showWtb != null) && (b.showWtb.equals("nie"))){
    			showWtb = false;
    			break;
    		}
    	}
    	
    	
    	Collections.sort(resultBuilding, new BuildingComparator());
    	
    	Map<Integer, List<Building>> resultBuildingMap = createMap(resultBuilding);
    	Map<Integer, List<Building>> resultBuildingMapCopy = createMap(resultBuilding);
    	
    	if (resultBuildingMap.size() > 0){
    		Set<Integer> keys = resultBuildingMap.keySet();
    		for (Integer key : keys){
    			List<Building> buildings = resultBuildingMap.get(key);
    			for (Building building : buildings){
    				if ( StringUtils.isNotEmpty(building.definition )){
    					resultBuildingDefinition = building.definition;
    					break;
    				}
    			}
    		}
    	}

    	// finally lest fins in text expressions
    	result = TextExpression.find("expression", expression);
    	resultTextExpression = result.fetch();
        
        // if not found, user entered synonym
        if (resultTextExpression.size() == 0){ 
        	result = DictionaryColloquialExpression.find("synonym_expression", expression);
        	List<DictionaryColloquialExpression> synonymResult = result.fetch();
        	for (DictionaryColloquialExpression colloquialExpression : synonymResult){
        		String expr = colloquialExpression.expression;
        		result = TextExpression.find("expression", expr);
        		resultTextExpression = result.fetch();
        	}
        	
        }
        
        if (resultTextExpression.size() > 0){
        	resultTextExpressionDefinition = resultTextExpression.get(0).definition;
        }
             
        boolean foundExpression = false;
        if (resultExpression.size() > 0 || resultBuilding.size() > 0 || resultTextExpressionDefinition.length() > 0){
        	foundExpression = true;
        	
        }
    	
    	render(expression, resultExpression, resultExpressionDefinition, resultBuilding, resultBuildingDefinition, resultBuildingMap, resultBuildingMapCopy, 
    			showWtb, resultTextExpressionDefinition, foundExpression);
    }

	private static Map<Integer, List<Building>> createMap(List<Building> resultBuilding) {
		
		SortedMap<Integer, List<Building>> resultBuildingMap = new TreeMap<Integer, List<Building>>();
		
		for (Building building : resultBuilding){
			if (building.isHeader.equals("1")){
				resultBuildingMap.put(Integer.parseInt(building.position), new ArrayList<Building>());
				resultBuildingMap.get(Integer.parseInt(building.position)).add(building);
			}
			if (building.isHeader.equals("0")){
				resultBuildingMap.get(resultBuildingMap.lastKey()).add(building);
			}
		}
				
		return resultBuildingMap;
	}

}
