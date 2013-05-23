package com.gtech.webservices;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement(name = "vacation_list")
public class VacationList {
    private Collection<Vacation> vacationList;

    @XmlElement(name = "vacation")
    public Collection<Vacation> getVacations()
    {
        return vacationList;
    }

    public void setVacations(Collection<Vacation> vacationList)
    {
        this.vacationList = vacationList;
    }
    
}
