package org.jboss.samples.webservices;

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
	/*@Autowired
	private SessionFactory sf;
		*/
	
	/* (non-Javadoc)
	 * @see org.jboss.samples.webservices.VacationDao#save(org.jboss.samples.webservices.Vacation)
	 */
	@Override
	public void save(Vacation vacation) {
		
		sf.getCurrentSession().save(vacation);
		//getHibernateTemplate().save(vacation);
	}
	/*
	public void delete(Vacation vacation)
	{
		sf.getCurrentSession().delete(vacation);
	}
	
	*/
	public Vacation get(int id) {
		return (Vacation) sf.getCurrentSession().get(Vacation.class, id);
	}
	/*
	private Contact findSingle(String hql, String paramName, Object value) {
		List<Contact> results = getHibernateTemplate().findByNamedParam(hql,
				paramName, value);
		return CollectionUtils.hasUniqueObject(results) ? results.get(0) : null;
	}
	*/
	/*
	public Collection<Vacation> findVacations()
	{
		
	}*/
	
    /* (non-Javadoc)
	 * @see org.jboss.samples.webservices.VacationDao#fakeVacation()
	 */
    @Override
	public Vacation fakeVacation(){
        Vacation vacation = new Vacation();
        
        vacation.setId(1);
        vacation.setUserName("gbielanski");
        vacation.setFlag(1);
        //vacation.setOD(new Date(System.currentTimeMillis()));
        Date  date = new Date();
        
        //vacation.setDO(date);
        //vacation.setTimeCreated(date);
        
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2013,4, 6, 0, 0, 0);
        
        Calendar cal2 = Calendar.getInstance();

        cal2.set(2013,5, 6, 0, 0, 0);
        vacation.setVacationSince(cal1);
        vacation.setVacationUntil(cal2);
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
    
    public List<Vacation> getVacations(String user, String vSince, String vUntil)
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
