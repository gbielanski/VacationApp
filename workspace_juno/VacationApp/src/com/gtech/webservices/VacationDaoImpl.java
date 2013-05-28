package com.gtech.webservices;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
//import org.springframework.util.CollectionUtils;

@Transactional
public class VacationDaoImpl extends HibernateDaoSupport implements VacationDao{
	
	@Autowired
	private SessionFactory sf;
	
	public VacationDaoImpl()
	{
		
	}	
	/* (non-Javadoc)
	 * @see org.jboss.samples.webservices.VacationDao#save(org.jboss.samples.webservices.Vacation)
	 */
	@Override
	public void save(Vacation vacation) {
		
		sf.getCurrentSession().save(vacation);
	}

	@Override
	public void updateSummary(VacationSummary vacationSummary) {
		
		sf.getCurrentSession().update(vacationSummary);
	}
	
	
	public Vacation update(Vacation vacation) {
		
		Vacation vacationForUpd= (Vacation)sf.getCurrentSession().get(Vacation.class, vacation.getId());
		
		vacationForUpd.setNumberOfDays(vacation.getNumberOfDays());
		vacationForUpd.setTypeOfVacation(vacation.getTypeOfVacation());
		
		/* I am not sure if required*/
		vacationForUpd.setUserName(vacation.getUserName());
		vacationForUpd.setVacationSince(vacation.getVacationSince());
		vacationForUpd.setVacationUntil(vacation.getVacationUntil());
		
		sf.getCurrentSession().update(vacationForUpd);
		
		return vacationForUpd;
	}

	public Vacation get(int id) {
		return (Vacation) sf.getCurrentSession().get(Vacation.class, id);
	}
	
    /* (non-Javadoc)
	 * @see org.jboss.samples.webservices.VacationDao#fakeVacation()
	 */
    @Override
	public Vacation fakeVacation(){
        Vacation vacation = new Vacation();
        
        vacation.setId(1);
        vacation.setUserName("gbielanski");
        
        Calendar cal1 = Calendar.getInstance();
        cal1.clear();
        cal1.set(2013,4, 6);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.clear();
        cal2.set(2013,5, 6);
        vacation.setVacationSince(cal1);
        vacation.setVacationUntil(cal2);
        vacation.setNumberOfDays(20);
        vacation.setTypeOfVacation(VacationType.VACATION);
        vacation.setStausOfVacationRequest(VacationStatus.WAITING_FOR_ACCEPTATION);
        vacation.setNumberOfOutstandingDaysUsed(2);

        return vacation;
    }
    
    /* (non-Javadoc)
	 * @see org.jboss.samples.webservices.VacationDao#fakeVacationSummary()
	 */
    @Override
	public VacationSummary fakeVacationSummary(){
        VacationSummary vacationSum = new VacationSummary();
        
        vacationSum.setName("gbielanski");
        vacationSum.setDaysAfterTheBirth(11);
        vacationSum.setDaysChildCare(12);
        vacationSum.setDaysJobSearch(13);
        vacationSum.setDaysOnDemand(14);
        vacationSum.setDaysOther(15);
        vacationSum.setDaysParental(16);
        vacationSum.setDaysSpecial(17);
        vacationSum.setDaysUnpaid(18);
        vacationSum.setDaysVacation(19);

        return vacationSum;
    }
    
    public List<Vacation> getVacationList(String user, String vSince, String vUntil)
    {
    	List<Vacation> vacations = sf.getCurrentSession().createQuery("FROM " + Vacation.class.getName() + 
    			" WHERE username = :user AND vacationsince > \'" + vSince + "\' AND vacationsince < \'" + vUntil +"\'")
    			.setString("user", user)
    			.list();
    	
    	return vacations;
    	
    }
    
    public VacationSummary getVacationSummary(String user)
    {
    	VacationSummary vacationSum= (VacationSummary)sf.getCurrentSession().createQuery("FROM " + VacationSummary.class.getName() + " WHERE name = :user").setString("user", user).uniqueResult();
    	return vacationSum;
    }
}
