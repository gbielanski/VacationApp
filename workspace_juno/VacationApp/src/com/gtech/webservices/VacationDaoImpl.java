package com.gtech.webservices;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.jboss.resteasy.spi.NotFoundException;
//import org.springframework.util.CollectionUtils;

@Transactional
public class VacationDaoImpl extends HibernateDaoSupport implements VacationDao{
	
	@Autowired
	private SessionFactory sf;
	
	public VacationDaoImpl()
	{
		
	}
	
	private Boolean isVacationPossible(Vacation vacationRequest, VacationSummary vacationSum)
	{
		int numberOfDays = vacationRequest.getNumberOfDays();
		
		switch(vacationRequest.getTypeOfVacation())
		{
		case VACATION: return numberOfDays<=vacationSum.getDaysVacation();
		case UNPAID: return numberOfDays<=vacationSum.getDaysUnpaid();
		case SPECIAL: return numberOfDays<=vacationSum.getDaysSpecial();
		case AFTER_THE_BIRTH: return numberOfDays<=vacationSum.getDaysAfterTheBirth();
		case CHILD_CARE: return numberOfDays<=vacationSum.getDaysChildCare();
		case JOB_SEARCH: return numberOfDays<=vacationSum.getDaysJobSearch();
		case ON_DEMOND: return numberOfDays<=vacationSum.getDaysOnDemand();
		case OTHER: return numberOfDays<=vacationSum.getDaysOther();
		case PARENTAL: return numberOfDays<=vacationSum.getDaysParental();
		default:
			return false; 
			
		}
	}
	
	public Vacation addVacationRequest(Vacation vacationRequest, String user)
	{
		
		VacationSummary vacationSum = getVacationSummary(user);
		
		if(isVacationPossible(vacationRequest, vacationSum) == false)
			throw new NotFoundException("It is not possible to add vacation");

		
		save(vacationRequest);
		
		updateSummary(vacationRequest, vacationSum, UpdateType.UPDATE_DECREASE);
		
		//TODO
		//getEscalationList(user);
		
		return vacationRequest; 
		
	}
	
	private Boolean isUpdatePossible(Vacation currentVacationRequest, Vacation newVacationRequest)
	{
		VacationStatus currentVacationStatus = currentVacationRequest.getStausOfVacationRequest();
		VacationStatus newVacationStatus = newVacationRequest.getStausOfVacationRequest();
		
		if(currentVacationStatus == VacationStatus.CANCELLED || currentVacationStatus == VacationStatus.REJECTED)
			return false;
		
		if(currentVacationStatus.ordinal() > newVacationStatus.ordinal())
			return false;
		
		return true;
	}
	
	private Boolean updateVacationSummaryAfterVacationUpdate(Vacation newVacation)
	{
		if(newVacation.getStausOfVacationRequest() == VacationStatus.CANCELLED || 
				newVacation.getStausOfVacationRequest() == VacationStatus.REJECTED)
			return true;
		
		return false;
	}
	
	public Vacation updateVacationRequest(Vacation vacationRequest, String user)
	{
		VacationSummary vacationSum = getVacationSummary(user);
		
		Vacation currentVacationRequest = get(vacationRequest.getId());
		
		if(isUpdatePossible(currentVacationRequest, vacationRequest) == false)
			throw new NotFoundException("It is not possible to update vacation");
		
		Vacation vacationUpdated =  update(vacationRequest);
		
		if(updateVacationSummaryAfterVacationUpdate(vacationUpdated)== true)
			updateSummary(vacationUpdated, vacationSum, UpdateType.UPDATE_INCREASE);
		
		//TODO
		//getEscalationList(user);
				
		return vacationUpdated;
	}	
	

	//private void save(Vacation vacation) {
	public void save(Vacation vacation) {	
		sf.getCurrentSession().save(vacation);
	}

	public void saveSummary(VacationSummary vacation) {	
		sf.getCurrentSession().save(vacation);
	}
	
	
	private void updateSummary(Vacation vacationRequest, VacationSummary vacationSummary, UpdateType updType) {

		int factor = 1;
		
		if(updType == UpdateType.UPDATE_DECREASE)
			factor = -1;

		switch(vacationRequest.getTypeOfVacation())
		{
		case VACATION: vacationSummary.setDaysVacation(vacationSummary.getDaysVacation() + factor * (vacationRequest.getNumberOfDays()));
			break;
		case UNPAID: vacationSummary.setDaysUnpaid(vacationSummary.getDaysUnpaid() + factor * (vacationRequest.getNumberOfDays()));
			break;
		case SPECIAL: vacationSummary.setDaysSpecial(vacationSummary.getDaysSpecial() + factor * ( vacationRequest.getNumberOfDays()));
			break;
		case AFTER_THE_BIRTH: vacationSummary.setDaysAfterTheBirth(vacationSummary.getDaysAfterTheBirth() + factor * (vacationRequest.getNumberOfDays()));
			break;
		case CHILD_CARE: vacationSummary.setDaysChildCare(vacationSummary.getDaysChildCare() + factor * (vacationRequest.getNumberOfDays()));
			break;
		case JOB_SEARCH: vacationSummary.setDaysJobSearch(vacationSummary.getDaysJobSearch() + factor * (vacationRequest.getNumberOfDays()));
			break;
		case ON_DEMOND: vacationSummary.setDaysOnDemand(vacationSummary.getDaysOnDemand() + factor * (vacationRequest.getNumberOfDays()));
			break;
		case OTHER: vacationSummary.setDaysOther(vacationSummary.getDaysOther() + factor * (vacationRequest.getNumberOfDays()));
			break;
		case PARENTAL: vacationSummary.setDaysParental(vacationSummary.getDaysParental() + factor * (vacationRequest.getNumberOfDays()));
			break;
		default:
			break; 
			
		}
		
		sf.getCurrentSession().update(vacationSummary);
	}
	
	
	private Vacation update(Vacation vacation) {
		
		Vacation vacationForUpd= (Vacation)sf.getCurrentSession().get(Vacation.class, vacation.getId());
		
		vacationForUpd.setNumberOfDays(vacation.getNumberOfDays());
		vacationForUpd.setTypeOfVacation(vacation.getTypeOfVacation());
		vacationForUpd.setStausOfVacationRequest(vacation.getStausOfVacationRequest());
		
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
    
    private EscalationList getEscalationList(String user)
    {
    	EscalationList escList= (EscalationList)sf.getCurrentSession().createQuery("FROM " + EscalationList.class.getName() + " WHERE name = :user").setString("user", user).uniqueResult();
    	return escList;
    }
}
