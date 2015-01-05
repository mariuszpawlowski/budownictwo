package controllers.utils;

import java.util.List;

import models.Company;

public class ApplicationUtils {

	public static String getColumnHeaderStyle(List<Company> resultCompany,
			List<Company> resultCompanyNear) {
		String headerStyle = "";
		
    	for (Company company : resultCompany){
    		if (!(headerStyle.length() >0)){
    			headerStyle = setHeaderStyle(company);  
    		} else{
    			break;
    		}
    		
    	}
    	
    	for (Company company : resultCompanyNear){
    		if (!(headerStyle.length() >0)){
    			headerStyle = setHeaderStyle(company);  
    		} else{
    			break;
    		}
    	}
		
		return headerStyle;
	}

	private static String setHeaderStyle(Company company) {
		String headerStyle = "";
		if ( company.line.equals(Dictionary.GEODEZJA) ){
			headerStyle = "tableHeaderGeodeta";
		} else if ( company.line.equals(Dictionary.GEOLOGIA) ){
			headerStyle = "tableHeaderGeolog";
		} else if ( company.line.equals(Dictionary.WENTYLACJA) ){
			headerStyle = "tableHeaderWentylacja";
		} else if ( company.line.equals(Dictionary.INSTALACJE_ELEKTRYCZNE) ){
			headerStyle = "tableHeaderElektryczne";
		} else if ( company.line.equals(Dictionary.INSTALACJE_GAZOWE) ){
			headerStyle = "tableHeaderGaz";
		} else if ( company.line.equals(Dictionary.BIURO_ARCHITEKTONICZNE) ){
			headerStyle = "tableHeaderArchitektoniczne";
		}
		return headerStyle;
	}

}
