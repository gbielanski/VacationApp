package com.gtech.webservices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ESCALATION_LIST")
public class EscalationList {
	@Id
	@GeneratedValue	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	private String userName;
	private String userMail;
	
	private String nameOfSupervisor1;
	private String nameOfSupervisor2;
	private String nameOfSupervisor3;
	
	private String mailOfSupervisor1;
	private String mailOfSupervisor2;
	private String mailOfSupervisor3;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getNameOfSupervisor1() {
		return nameOfSupervisor1;
	}
	public void setNameOfSupervisor1(String nameOfSupervisor1) {
		this.nameOfSupervisor1 = nameOfSupervisor1;
	}
	public String getNameOfSupervisor2() {
		return nameOfSupervisor2;
	}
	public void setNameOfSupervisor2(String nameOfSupervisor2) {
		this.nameOfSupervisor2 = nameOfSupervisor2;
	}
	public String getNameOfSupervisor3() {
		return nameOfSupervisor3;
	}
	public void setNameOfSupervisor3(String nameOfSupervisor3) {
		this.nameOfSupervisor3 = nameOfSupervisor3;
	}
	public String getMailOfSupervisor1() {
		return mailOfSupervisor1;
	}
	public void setMailOfSupervisor1(String mailOfSupervisor1) {
		this.mailOfSupervisor1 = mailOfSupervisor1;
	}
	public String getMailOfSupervisor2() {
		return mailOfSupervisor2;
	}
	public void setMailOfSupervisor2(String mailOfSupervisor2) {
		this.mailOfSupervisor2 = mailOfSupervisor2;
	}
	public String getMailOfSupervisor3() {
		return mailOfSupervisor3;
	}
	public void setMailOfSupervisor3(String mailOfSupervisor3) {
		this.mailOfSupervisor3 = mailOfSupervisor3;
	}
	
}
