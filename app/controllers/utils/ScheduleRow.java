package controllers.utils;

public class ScheduleRow {

	public String rowName;
	public String month1;
	public String month2;
	public String month3;
	public String month4;
	public String month5;
	public String month6;
	public String month7;
	public String month8;
	public String month9;
	public String month10;
	public String month11;
	
	public ScheduleRow(String scheduleRowName, String month1, String month2,
			String month3, String month4, String month5, String month6,
			String month7, String month8, String month9, String month10,
			String month11) {
		
		rowName = scheduleRowName;
		this.month1 = month1;
		this.month2 = month2;
		this.month3 = month3;
		this.month4 = month4;
		this.month5 = month5;
		this.month6 = month6;
		this.month7 = month7;
		this.month8 = month8;
		this.month9 = month9;
		this.month10 = month10;
		this.month11 = month11;
	}

	public ScheduleRow(String name, int[] months) {
		this.rowName = name;
		for( int i = 0; i < months.length; i++){
			int value = months[i];
			if ( value == 1){
				this.month1 = Dictionary.YES; 
			}
			if ( value == 2){
				this.month2 = Dictionary.YES; 
			} 
			if ( value == 3){
				this.month3 = Dictionary.YES; 
			} 
			if ( value == 4){
				this.month4 = Dictionary.YES; 
			} 
			if ( value == 5){
				this.month5 = Dictionary.YES; 
			} 
			if ( value == 6){
				this.month6 = Dictionary.YES; 
			} 
			if ( value == 7){
				this.month7 = Dictionary.YES; 
			} 
			if ( value == 8){
				this.month8 = Dictionary.YES; 
			} 
			if ( value == 9){
				this.month9 = Dictionary.YES; 
			} 
			if ( value == 10){
				this.month10 = Dictionary.YES; 
			} 
			if ( value == 11){
				this.month11 = Dictionary.YES; 
			} 
		}
	}
}
