package com.gtech.webservices;
import java.util.List;

public interface VacationDao {

	public abstract void save(Vacation vacation);
	
	public abstract Vacation update(Vacation vacation);

	public abstract void updateSummary(VacationSummary vacationSummary);
	public abstract Vacation get(int id);
	
	public abstract List<Vacation> getVacationList(String user, String vSince, String vUntil);
	public abstract VacationSummary getVacationSummary(String user);
	 
	public abstract Vacation fakeVacation();

	public abstract VacationSummary fakeVacationSummary();

}