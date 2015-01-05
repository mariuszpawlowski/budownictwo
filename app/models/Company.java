package models;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.data.validation.MaxSize;
import play.db.jpa.Model;

@Entity
@Table (name="Companies")
public class Company extends Model {
	
	public int index;
	
	@MaxSize(300)
	public String companyName;

	@MaxSize(100)
	public String city;
	
	@MaxSize(300)
	public String address;
	
	@MaxSize(100)
	public String province;
	
	@MaxSize(50)
	public String phone;
	
	@MaxSize(100)
	public String www;
	
	@MaxSize(100)
	public String email;
	
	@MaxSize(100)
	public String line;
	
	@MaxSize(300)
	public String remarks;
	
	@MaxSize(100)
	public String position;
	
	@MaxSize(500)
	public String mapLink;
	
	@MaxSize(100)
	public String latitude; // szerokosc
	
	@MaxSize(100)
	public String longitude;  // dlugosc 
	
	
}
