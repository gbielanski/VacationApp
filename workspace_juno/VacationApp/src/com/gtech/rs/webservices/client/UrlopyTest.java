package com.gtech.rs.webservices.client;


import static org.junit.Assert.*;

import org.jboss.resteasy.client.ProxyFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gtech.rs.webservices.*;

public class UrlopyTest {

	@Before
	public void setUp() throws Exception {
		org.jboss.resteasy.plugins.providers.RegisterBuiltin.register(org.jboss.resteasy.spi.ResteasyProviderFactory.getInstance());
	}

	@After
	public void tearDown() throws Exception{
		
	}
	
	@Test
	public void test() {
		VacationAppInterface client = ProxyFactory.create(VacationAppInterface.class, "http://localhost:8080/AplikacjaUrlopowa/");
		Vacation r = client.addVacation();// .dajMiesiac(/*1, 2*/);
				
		System.out.println("=>>" + r);
	}

}
