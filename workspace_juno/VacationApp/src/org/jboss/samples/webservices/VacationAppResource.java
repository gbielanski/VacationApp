package org.jboss.samples.webservices;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


public class VacationAppResource implements VacationAppInterface{

	private VacationDao vacationDAO;
	//@Context javax.ws.rs.core.SecurityContext sec; 
	@Override
	@GET
	@Path("/Vacations/{vacationSince}/{vacationUntil}")
	@Produces({ "application/json", "application/xml" })
	public Vacations getVacations(String auth, String vacationSince, String vacationUntil) {		
		
		//vacationDAO.save(vacationDAO.fakeVacation());
		Vacations vacations = new Vacations();
		vacations.setVacations(vacationDAO.getVacations(getUserFromAuth(auth), vacationSince, vacationUntil));
		
		//System.out.println("[VACATION GET] vacationSince " + vacationSince + " vacationUntil " + vacationUntil);
		
		return vacations;
	}

	@GET
	@Path("/VacationsSummary")
	@Produces({ "application/json", "application/xml" })
	public VacationSummary getVacationsSummary(String auth) {
        
        //vacationDAO.saveSummary(vacationDAO.fakeVacation());
		//return vacationDAO.fakeVacationSummary();
        
        return vacationDAO.getVacationSummary(getUserFromAuth(auth));
	}

	@Override
	@POST
	@Path("/NewVacation")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Vacation addVacation(Vacation vacation) {
		// TODO Auto-generated method stub
		vacationDAO.save(vacation);
		return vacation;
		
	}

	@Override
	@POST
	@Path("/ExistingVacation")
	@Consumes({ "application/json", "application/xml" })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Vacation updateVacation(Vacation vacation) {
		
		Vacation vUpdated = vacationDAO.update(vacation);
		return vUpdated;
	}
	
	public VacationDao getVacationDao() {
		return vacationDAO;
	}

	public void setVacationDao(VacationDao vacationDao) {
		this.vacationDAO = vacationDao;
		}
	
	private String getUserFromAuth(String auth)
	{
		String userAndPassword64 = auth.replace("Basic ", "");
		
		byte[] encodedDataAsBytes =  javax.xml.bind.DatatypeConverter.parseBase64Binary(userAndPassword64);
		String val ="";
		try {
			val = new String(encodedDataAsBytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        String user = val.substring(0, val.indexOf(':'));
        /*String pass = val.substring(val.indexOf(':') + 1);*/	
		
        return user;
	}
}
