package org.jboss.samples.webservices;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="VACATIONS")
@XmlRootElement
public class Vacation{
	@Id
	@GeneratedValue	
	private int id;
	private int flag;
	
	private String userName;
	private Calendar vacationSince;
	private Calendar vacationUntil;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	  public String getUserName() {
		    return userName;
		  }

		  public void setUserName(String name) {
		    this.userName = name;
		  }
	
	  @Temporal(TemporalType.TIME)
	  public Calendar getVacationSince() { return vacationSince; }
	  public void setVacationSince(Calendar cal) { vacationSince = cal; }

	  @Temporal(TemporalType.TIME)
	  public Calendar getVacationUntil() { return vacationUntil; }
	  public void setVacationUntil(Calendar cal) { vacationUntil = cal; }
	  /*
	private Calendar DO;
	
	@Temporal(TemporalType.DATE)
	public Calendar getDO() {
		return DO;
	}
	@Temporal(TemporalType.DATE)
	public void setDO(Calendar DO) {
		this.DO = DO;
		
	}*/
	/*
	private int sinceDay;
	public int getSinceDay() {
		return sinceDay;
	}
	
	public void setSinceDay(int sinceDay) {
		this.sinceDay = sinceDay;
	}
	
	private Date DO;
	public Date getDO() {
		return DO;
	}
	
	public void setDO(Date DO) {
		this.DO = DO;
	}
	*/

	  public String toString() {
		    return "Vacation";
		  }
	public int getFlag() {
		return flag;
	}
	
	public void setFlag(int flag) {
		this.flag = flag;
	}	
}
