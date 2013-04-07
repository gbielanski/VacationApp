package org.jboss.samples.rs.webservices;

import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;

@XmlRootElement
public class Urlop {
	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String nazwa;
	
	public String getName() {
		return nazwa;
	}

	public void setName(String nazwa) {
		this.nazwa = nazwa;
	}
	
	private Date OD;
	public Date getOD() {
		return OD;
	}
	
	public void setOD(Date OD) {
		this.OD = OD;
	}
	
	private Date DO;
	public Date getDO() {
		return DO;
	}
	
	public void setDO(Date DO) {
		this.DO = DO;
	}
	
	private int flag;
	
	public int getFlag() {
		return flag;
	}
	
	public void setFlag(int flag) {
		this.flag = flag;
	}	
}
