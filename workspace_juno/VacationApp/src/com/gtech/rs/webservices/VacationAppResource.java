package com.gtech.rs.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.annotation.security.RolesAllowed;


public class VacationAppResource implements VacationAppInterface{

	private VacationDOA vacationDAO =  new VacationDOA();
	@Context javax.ws.rs.core.SecurityContext sec; 
	
	public Vacation getVacations(/*int rok, int miesiac*/) {


		if(sec.isUserInRole("admin"))
			System.out.println("User Role is admin");
		else if(sec.isUserInRole("user"))
			System.out.println("User Role is user");
		else
			System.out.println("User Role is none");

		return vacationDAO.fakeVacation();
	
	}

	public Vacation getVacationsSummary() {
		// TODO Auto-generated method stub
		return vacationDAO.fakeVacation();
	}


	public Vacation addVacation() {
		// TODO Auto-generated method stub
		return vacationDAO.fakeVacation();
	}

	public Vacation updateVacation() {
		// TODO Auto-generated method stub
		return vacationDAO.fakeVacation();
	}
}
