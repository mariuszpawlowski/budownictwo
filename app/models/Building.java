package models;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table (name="Buildings")
public class Building extends Model {

	@MaxSize(200)
	@Required
	public String expression;
	
	@MaxSize(5000)
	public String definition;
	
	@MaxSize(5000)
	public String PB;

	@MaxSize(5000)
	public String WTB;

	@MaxSize(5000)
	public String law_other;
	
	@MaxSize(5000)
	public String additional_info;
	
	public String position;
	
	public String isHeader;
	
	public String showWtb;
	
}
