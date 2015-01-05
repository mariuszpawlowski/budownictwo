package controllers;

import play.*;
import play.data.validation.Required;
import play.db.jpa.GenericModel.JPAQuery;
import play.db.jpa.JPA;
import play.mvc.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;


import models.*;

public class Index extends Controller {

	public static void buildings() throws UnsupportedEncodingException{
		
		List<String> expressions = new ArrayList<String>(); 
		
		JPAQuery result = Building.find("select b from Building b");	
		List<Building> buildingResult = result.fetch();
		
		for (Building building : buildingResult){
			if (StringUtils.isNotEmpty(building.expression)){
				if (!expressions.contains(building.expression.trim())){
					expressions.add(building.expression.trim());
				}
			}
		}
		
		result = TextExpression.find("select t from TextExpression t where t.indexBuildings = ?", "tak");
		List<TextExpression> textExpressionResult = result.fetch();
		
		for (TextExpression textExpression : textExpressionResult){
			if (StringUtils.isNotEmpty(textExpression.expression)){
				if (!expressions.contains(textExpression.expression.trim())){
					expressions.add(textExpression.expression.trim());
				}
			}
		}
		
		ExpressionComparator expressionComparator = new ExpressionComparator();  
		Collections.sort(expressions, expressionComparator);
		render(expressions);
	}
	
	public static void expressions() throws UnsupportedEncodingException{
		
		
		List<String> expressions = new ArrayList<String>(); 
		
		JPAQuery result = Expression.find("select e from Expression e");	
		List<Expression> expressionResult = result.fetch();
		
		for (Expression expression : expressionResult){
			if (StringUtils.isNotEmpty(expression.expression)){
				if (!expressions.contains(expression.expression.trim())){
					expressions.add(expression.expression.trim());
				}
			}
		}
		
		result = TextExpression.find("select t from TextExpression t where t.indexExpressions = ?", "tak");
		List<TextExpression> textExpressionResult = result.fetch();
		
		for (TextExpression textExpression : textExpressionResult){
			if (StringUtils.isNotEmpty(textExpression.expression)){
				if (!expressions.contains(textExpression.expression.trim())){
					expressions.add(textExpression.expression.trim());
				}
			}
		}
		
		ExpressionComparator expressionComparator = new ExpressionComparator();  
		Collections.sort(expressions, expressionComparator);
		
		render(expressions);
	}
	
    
}
