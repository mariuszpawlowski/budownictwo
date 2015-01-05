package models;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table (name="Dictionary_Colloquial_Expressions_line")
public class DictionaryColloquialExpressionsLine extends Model {
	
	@Required
	public String expression;
	
	@Required
	public String synonym_expression;


}
