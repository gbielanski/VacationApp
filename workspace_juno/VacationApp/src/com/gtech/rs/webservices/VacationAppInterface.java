package com.gtech.rs.webservices;


import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@RolesAllowed({"admin", "user"})
public interface VacationAppInterface {
	
	@GET() @Path("/Vacations")
	@Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Vacation getVacations(/*@QueryParam("rok")int rok, @QueryParam("miesiac")int miesiac*/);
	
	@GET() @Path("/VacationsSummary")
	@Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Vacation getVacationsSummary(/*@QueryParam("rok")int rok, @QueryParam("miesiac")int miesiac*/);	

	@POST() @Path("/NewVacation")
	@Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	@Consumes({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Vacation addVacation(/*@QueryParam("rok")int rok, @QueryParam("miesiac")int miesiac*/);	
	
	@POST() @Path("/ExistingVacation")
	@Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	@Consumes({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Vacation updateVacation(/*@QueryParam("rok")int rok, @QueryParam("miesiac")int miesiac*/);	
}
