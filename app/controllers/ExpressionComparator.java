package controllers;

import java.util.Comparator;

public class ExpressionComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		
		String  expr1 = o1.toLowerCase();
		String  expr2 = o2.toLowerCase();
		
		int compare = expr1.compareTo(expr2);  
		if (compare < 0){  
		    return -1;  
		} else if (compare > 0){  
		    return 1;  
		} else {  
			return 0;
		} 
	}
}

