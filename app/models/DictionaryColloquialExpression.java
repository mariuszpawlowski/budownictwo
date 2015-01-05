package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.MaxSize;
import play.data.validation.Required;

import play.db.jpa.Model;

@Entity
@Table (name="Dictionary_Colloquial_Expressions")
public class DictionaryColloquialExpression extends Model	 {
	
	
	
	@Required
	public String expression;
	
	@Required
	public String synonym_expression;

}
