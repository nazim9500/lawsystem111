package com.lawSys.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblotno")
public class Lotno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int lotnoid;	
	private String vlotno;
	private String vshape;
	private String vsize;
	private Double ncarats;
	private String vdscrptn;
	private String vquality;
	
	private String luser;
	private Date ldate;
	public int getLotnoid() {
		return lotnoid;
	}
	public void setLotnoid(int lotnoid) {
		this.lotnoid = lotnoid;
	}
	public String getVlotno() {
		return vlotno;
	}
	public void setVlotno(String vlotno) {
		this.vlotno = vlotno;
	}
	public String getVshape() {
		return vshape;
	}
	public void setVshape(String vshape) {
		this.vshape = vshape;
	}
	public String getVsize() {
		return vsize;
	}
	public void setVsize(String vsize) {
		this.vsize = vsize;
	}
	public Double getNcarats() {
		return ncarats;
	}
	public void setNcarats(Double ncarats) {
		this.ncarats = ncarats;
	}
	public String getVdscrptn() {
		return vdscrptn;
	}
	public void setVdscrptn(String vdscrptn) {
		this.vdscrptn = vdscrptn;
	}
	public String getVquality() {
		return vquality;
	}
	public void setVquality(String vquality) {
		this.vquality = vquality;
	}
	public String getLuser() {
		return luser;
	}
	public void setLuser(String luser) {
		this.luser = luser;
	}
	public Date getLdate() {
		return ldate;
	}
	public void setLdate(Date date) {
		this.ldate = date;
	}	
}
