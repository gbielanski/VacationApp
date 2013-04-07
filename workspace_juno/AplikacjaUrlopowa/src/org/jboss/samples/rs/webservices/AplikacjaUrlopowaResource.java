package org.jboss.samples.rs.webservices;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.annotation.security.RolesAllowed;


//@RolesAllowed("admin")
public class AplikacjaUrlopowaResource implements AplikacjaUrlopowaInterface{

	@Context javax.ws.rs.core.SecurityContext sec; 
	
	//@RolesAllowed({"admin"})
	public Urlop dajMiesiac(/*int rok, int miesiac*/) {
		UrlopDOA urlopDAO =  new UrlopDOA();
		//sr.getSession().getId();
		if(sec.isUserInRole("admin"))
			return urlopDAO.fakeUrlop("admin");
		else if(sec.isUserInRole("user"))
			return urlopDAO.fakeUrlop("user");
		else
			return urlopDAO.fakeUrlop("none");
	    //return "Aplikacja urlopowa rok t: " /*+ rok + " miesiac: " + miesiac + " Interface admin"*/;
	}
}
