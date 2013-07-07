package com.gtech.webservices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;

@Entity
@Table(name="VACATIONS_SUMMARY")
@XmlRootElement
public class VacationSummary 
{
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String name;
	@Min(0)
	private int daysVacation;
	@Min(0)	
	private int daysUnpaid;
	@Min(0)	
	private int daysSpecial;
	@Min(0)	
	private int daysParental;
	@Min(0)	
	private int daysAfterTheBirth;
	@Min(0)	
	private int daysOnDemand;
	@Min(0)	
	private int daysChildCare;
	@Min(0)	
	private int daysJobSearch;
	@Min(0)	
	private int daysOther;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDaysVacation() {
		return daysVacation;
	}
	public void setDaysVacation(int daysVacation) {
		this.daysVacation = daysVacation;
	}
	public int getDaysUnpaid() {
		return daysUnpaid;
	}
	public void setDaysUnpaid(int daysUnpaid) {
		this.daysUnpaid = daysUnpaid;
	}
	public int getDaysSpecial() {
		return daysSpecial;
	}
	public void setDaysSpecial(int daysSpecial) {
		this.daysSpecial = daysSpecial;
	}
	public int getDaysParental() {
		return daysParental;
	}
	public void setDaysParental(int daysParental) {
		this.daysParental = daysParental;
	}
	public int getDaysAfterTheBirth() {
		return daysAfterTheBirth;
	}
	public void setDaysAfterTheBirth(int daysAfterTheBirth) {
		this.daysAfterTheBirth = daysAfterTheBirth;
	}
	public int getDaysOnDemand() {
		return daysOnDemand;
	}
	public void setDaysOnDemand(int daysOnDemand) {
		this.daysOnDemand = daysOnDemand;
	}
	public int getDaysChildCare() {
		return daysChildCare;
	}
	public void setDaysChildCare(int daysChildCare) {
		this.daysChildCare = daysChildCare;
	}
	public int getDaysJobSearch() {
		return daysJobSearch;
	}
	public void setDaysJobSearch(int daysJobSearch) {
		this.daysJobSearch = daysJobSearch;
	}
	public int getDaysOther() {
		return daysOther;
	}
	public void setDaysOther(int daysOther) {
		this.daysOther = daysOther;
	}
	
}
