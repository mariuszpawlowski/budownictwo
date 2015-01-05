package models;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table (name="Expressions")
public class Expression extends Model {
	
	@Required
	public String expression;

	@MaxSize(5000)
	@Required
	public String definition;
	
	@MaxSize(5000)
	public String description;
	
	@MaxSize(5000)
	public String law;
	
	@MaxSize(5000)
	public String additionalInformation;
	
}
