package org.jboss.samples.webservices;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement(name = "vacations")
public class Vacations {
    private Collection<Vacation> vacations;

    @XmlElement(name = "vacation")
    public Collection<Vacation> getVacations()
    {
        return vacations;
    }

    public void setVacations(Collection<Vacation> vacations)
    {
        this.vacations = vacations;
    }
    
}
