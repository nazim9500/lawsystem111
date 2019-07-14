package com.lawSys.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lawyer")
public class Lawyer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int lawyerid;
	private String lname;
	private String lcontact;
	private String lexperties;
	private String lavailability;
	private int lage;
	public int getLawyerid() {
		return lawyerid;
	}
	public void setLawyerid(int lawyerid) {
		this.lawyerid = lawyerid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLcontact() {
		return lcontact;
	}
	public void setLcontact(String lcontact) {
		this.lcontact = lcontact;
	}
	public String getLexperties() {
		return lexperties;
	}
	public void setLexperties(String lexperties) {
		this.lexperties = lexperties;
	}
	public String getLavailability() {
		return lavailability;
	}
	public void setLavailability(String lavailability) {
		this.lavailability = lavailability;
	}
	public int getLage() {
		return lage;
	}
	public void setLage(int lage) {
		this.lage = lage;
	}
	
	
	
}
