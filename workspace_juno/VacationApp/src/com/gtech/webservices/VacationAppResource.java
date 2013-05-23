package com.gtech.webservices;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;
import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
	 @Resource(mappedName = "java:jboss/mail/VacApp_GMAIL")
	 javax.mail.Session mailSession;
	 
	private VacationDao vacationDAO;
	//@Context javax.ws.rs.core.SecurityContext sec; 
	@Override
	@GET
	@Path("/VacationList/{vacationSince}/{vacationUntil}")
	@Produces({ "application/json", "application/xml" })
	public VacationList getVacationList(String auth, String vacationSince, String vacationUntil) {		
		
		vacationDAO.save(vacationDAO.fakeVacation());
		VacationList vacations = new VacationList();
		vacations.setVacations(vacationDAO.getVacations(getUserFromAuth(auth), vacationSince, vacationUntil));
		
		//System.out.println("[VACATION GET] vacationSince " + vacationSince + " vacationUntil " + vacationUntil);
		
/*************************
        //
        // Creates email message
        //
		   String to = "gbielanski@poczta.onet.pl";
		   String from = "grzegorzbielanski@gmail.com";
		   String subject = "Testing...";
		   Message msg = new MimeMessage(mailSession);
		    try {
		      msg.setFrom(new InternetAddress(from));
		      msg.setRecipient(Message.RecipientType.TO , new InternetAddress(to));
		      msg.setSubject(subject);
		      msg.setText("Working fine..!");
		    }  catch(Exception exc) {
		       }

        //
        // Send a message
        //
        try {
			Transport.send(msg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
***************************/		
		
		return vacations;
	}

	@GET
	@Path("/VacationSummary")
	@Produces({ "application/json", "application/xml" })
	public VacationSummary getVacationSummary(String auth) {
        
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
