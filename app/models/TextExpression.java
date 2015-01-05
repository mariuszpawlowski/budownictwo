package models;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table (name="TextExpressions")
public class TextExpression extends Model{
	
	@Required
	public String expression;

	@MaxSize(60000)
	@Required
	public String definition;
	
	public String indexBuildings;
	
	public String indexExpressions;

}

