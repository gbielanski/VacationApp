package org.jboss.samples.rs.webservices;


import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@RolesAllowed({"admin", "user"})
@Path("/AplikacjaUrlopowa1")
public interface AplikacjaUrlopowaInterface {
	
	@GET()
	@RolesAllowed({"admin", "user"})
	@Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Urlop dajMiesiac(/*@QueryParam("rok")int rok, @QueryParam("miesiac")int miesiac*/);

}
