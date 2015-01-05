package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table (name="Users")
public class User extends Model{
	
	@Required
	public String login;
	@Required
	public String password;
}
