package org.jboss.samples.webservices;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;


public class VacationAppResource implements VacationAppInterface{

	@Context javax.servlet.http.HttpServletRequest sr;
	private VacationDOA vacationDAO =  new VacationDOA();
	//@Context javax.ws.rs.core.SecurityContext sec; 
	@Override
	@GET
	@Path("/Vacations")
	@Produces({ "application/json", "application/xml" })
	public Vacation getVacations(/*int rok, int miesiac*/) {

/*
		if(sec.isUserInRole("admin"))
			System.out.println("User Role is admin");
		else if(sec.isUserInRole("user"))
			System.out.println("User Role is user");
		else
			System.out.println("User Role is none");
*/
		return vacationDAO.fakeVacation();
	
	}

	@Override
	@GET
	@Path("/VacationsSummary")
	@Produces({ "application/json", "application/xml" })
	public VacationSummary getVacationsSummary(@QueryParam("rok") int rok,
			@QueryParam("miesiac") int miesiac) {
		// TODO Auto-generated method stub
		return vacationDAO.fakeVacationSummary();
	}

	@Override
	@POST
	@Path("/NewVacation")
	@Produces({ "application/json", "application/xml" })
	@Consumes({ "application/json", "application/xml" })
	public Vacation addVacation(@PathParam("rok") int rok,
			@PathParam("miesiac") int miesiac) {
		// TODO Auto-generated method stub
		return vacationDAO.fakeVacation();
	}

	@Override
	@POST
	@Path("/ExistingVacation")
	@Produces({ "application/json", "application/xml" })
	@Consumes({ "application/json", "application/xml" })
	public Vacation updateVacation(@PathParam("rok") int rok,
			@PathParam("miesiac") int miesiac) {
		// TODO Auto-generated method stub
		return vacationDAO.fakeVacation();
	}
}
