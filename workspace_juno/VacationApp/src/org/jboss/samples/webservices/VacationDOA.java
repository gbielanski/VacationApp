package org.jboss.samples.webservices;

import java.util.Date;


//Hibernate here
public class VacationDOA {
    public Vacation fakeVacation(){
        Vacation vacation = new Vacation();
        
        vacation.setId(1);
        vacation.setName("Grzegorz Bielañski");
        vacation.setFlag(1);
        vacation.setOD(new Date(System.currentTimeMillis()));
        vacation.setDO(new Date(System.currentTimeMillis()+ 86400000));

        return vacation;
    }
    
    public VacationSummary fakeVacationSummary(){
        VacationSummary vacationSum = new VacationSummary();
        
        vacationSum.setId(1);
        vacationSum.setName("Grzegorz Bielañski");
        vacationSum.setFlag(1);
        vacationSum.setOD(new Date(System.currentTimeMillis()));
        vacationSum.setDO(new Date(System.currentTimeMillis()+ 86400000));

        return vacationSum;
    }
}
