package org.jboss.samples.webservices;

import java.util.Date;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
//import org.springframework.util.CollectionUtils;

@Transactional
public class VacationDaoImpl extends HibernateDaoSupport implements VacationDao{
	
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
		
		getHibernateTemplate().save(vacation);
		/*
		if(sf == null) 
		{
			sf.getCurrentSession().save(vacation);
		}else;*/	
		//sf.getCurrentSession().save(vacation);		
	}
	/*
	public void delete(Vacation vacation)
	{
		sf.getCurrentSession().delete(vacation);
	}
	
	
	public Vacation get(int id) {
		return (Vacation) sf.getCurrentSession().get(Vacation.class, id);
	}
	*/	
    /* (non-Javadoc)
	 * @see org.jboss.samples.webservices.VacationDao#fakeVacation()
	 */
    @Override
	public Vacation fakeVacation(){
        Vacation vacation = new Vacation();
        
        vacation.setId(1);
        vacation.setName("Grzegorz Bielañski");
        vacation.setFlag(1);
        //vacation.setOD(new Date(System.currentTimeMillis()));
        //vacation.setDO(new Date(System.currentTimeMillis()+ 86400000));

        return vacation;
    }
    
    /* (non-Javadoc)
	 * @see org.jboss.samples.webservices.VacationDao#fakeVacationSummary()
	 */
    @Override
	public VacationSummary fakeVacationSummary(){
        VacationSummary vacationSum = new VacationSummary();
        
        vacationSum.setId(1);
        vacationSum.setName("Grzegorz Bielañski");
        vacationSum.setFlag(1);
        vacationSum.setOD(new Date(System.currentTimeMillis()));
        vacationSum.setDO(new Date(System.currentTimeMillis()+ 86400000));

        return vacationSum;
    }
}
