package org.jboss.samples.rs.webservices.client;

import org.jboss.samples.rs.webservices.*;

import static org.junit.Assert.*;

import org.jboss.resteasy.client.ProxyFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		AplikacjaUrlopowaInterface client = ProxyFactory.create(AplikacjaUrlopowaInterface.class, "http://localhost:8080/AplikacjaUrlopowa/");
		Urlop r = client.dajMiesiac(/*1, 2*/);
				
		System.out.println("=>>" + r);
	}

}
