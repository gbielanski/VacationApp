package com.gtech.webservices;


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
	
	@GET() @Path("/VacationList/{vacationSince}/{vacationUntil}")
	@Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public abstract VacationList getVacationList(@HeaderParam("Authorization") String auth, 
			@PathParam("vacationSince") String vacationSince, @PathParam("vacationUntil") String vacationUntil);

	@GET() @Path("/VacationSummary")
	@Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public abstract VacationSummary getVacationSummary(@HeaderParam("Authorization") String auth);	

	@POST() @Path("/NewVacation")
	@Consumes({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public abstract Vacation addVacation(@HeaderParam("Authorization") String auth, Vacation vacation);	
	
	@POST() @Path("/ExistingVacation")	
	@Consumes({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public abstract Vacation updateVacation(@HeaderParam("Authorization") String auth, Vacation vacation);
}
