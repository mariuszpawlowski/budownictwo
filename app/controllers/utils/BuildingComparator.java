package controllers.utils;

import java.util.Comparator;

import com.sun.corba.se.impl.oa.poa.POAImpl;

import models.Building;

public class BuildingComparator implements Comparator<Building> {

	@Override
	public int compare(Building o1, Building o2) {
		int compareValue = 0;
		int position1 = Integer.parseInt(o1.position);
		int position2 = Integer.parseInt(o2.position);
		
		if ( position1 < position2){
			compareValue = -1;
		} else {
			compareValue = 1;
		}
		
		return compareValue;
	}

}
