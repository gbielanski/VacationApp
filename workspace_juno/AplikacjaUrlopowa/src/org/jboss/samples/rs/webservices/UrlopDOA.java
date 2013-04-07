package org.jboss.samples.rs.webservices;

import java.util.Date;

public class UrlopDOA {
    public Urlop fakeUrlop(String sr){
        Urlop urlop = new Urlop();
        
        urlop.setId(1);
        urlop.setName("Grzegorz Bielañski" + sr);
        urlop.setFlag(1);
        urlop.setOD(new Date(System.currentTimeMillis()));
        urlop.setDO(new Date(System.currentTimeMillis()+ 86400000));

        return urlop;
    }
}
