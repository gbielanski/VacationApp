package org.jboss.samples.webservices;
import java.util.List;

public interface VacationDao {

	public abstract void save(Vacation vacation);
	
	public abstract Vacation update(Vacation vacation);

	/*
	public void delete(Vacation vacation)
	{
		sf.getCurrentSession().delete(vacation);
	}
	
	*/
	public abstract Vacation get(int id);
	
	public abstract List<Vacation> getVacations(String user, String vSince, String vUntil);
	public abstract VacationSummary getVacationSummary(String user);
	 
	public abstract Vacation fakeVacation();

	public abstract VacationSummary fakeVacationSummary();

}