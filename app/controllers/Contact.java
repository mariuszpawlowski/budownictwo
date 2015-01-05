package controllers;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import play.data.validation.Required;
import play.libs.Mail;
import play.mvc.Controller;

public class Contact extends Controller {
	public static void index(){
		render();
	}
	
	public static void advertisement(){
		render();
	}
	
	public static void sendContactMail(@Required String email, String name, String message){
		boolean wrongEmail = false;
		SimpleEmail simpleEmail = new SimpleEmail();
		try {
			simpleEmail.setFrom("formularz@jakwybudowac.pl", name);
			simpleEmail.addReplyTo(email, name);
			simpleEmail.addTo("biuro@jakwybudowac.pl");
			simpleEmail.setSubject("Kontakt ze strony jakwybudowac.pl");
			simpleEmail.setMsg(message);
			simpleEmail.setCharset("UTF-8");
			Mail.send(simpleEmail); 
		} catch (EmailException e) {
			e.printStackTrace();
			if (e.getCause().toString().contains("@domain")){
				wrongEmail = true;
			}
			
		}
		
		render(wrongEmail);
	}
	
}
