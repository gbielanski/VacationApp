package org.jboss.samples.webservices;


import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@RolesAllowed({"admin", "user"})
@Path("/Rest")
public interface VacationAppInterface {
	
	@GET() @Path("/Vacations/{vacationSince}/{vacationUntil}")
	@Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public abstract Vacations getVacations(@HeaderParam("Authorization") String auth, 
			@PathParam("vacationSince") String vacationSince, @PathParam("vacationUntil") String vacationUntil);

	@GET() @Path("/VacationsSummary")
	@Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public abstract VacationSummary getVacationsSummary(@HeaderParam("Authorization") String auth);	

	@POST() @Path("/NewVacation")
	@Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	@Consumes({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public abstract Vacation addVacation(@PathParam("rok")int rok, @PathParam("miesiac")int miesiac);	
	
	@POST() @Path("/ExistingVacation")
	@Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	@Consumes({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public abstract Vacation updateVacation(@PathParam("rok")int rok, @PathParam("miesiac")int miesiac);
}
