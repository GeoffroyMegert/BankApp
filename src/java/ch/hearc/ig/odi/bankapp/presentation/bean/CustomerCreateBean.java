package ch.hearc.ig.odi.bankapp.presentation.bean;

import ch.hearc.ig.odi.bankapp.services.Services;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
@Named("CustomerCreateBean")
@SessionScoped
public class CustomerCreateBean implements Serializable {
    
    private int id;
    private String firstName;
    private String lastName;
    
    @Inject
    private Services services;
    
    public String submit() {
        System.out.println(services.getCustomersList().size());
        services.saveCustomer(id, firstName, lastName);
        System.out.println(services.getCustomersList().size());
        
        return "success";
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    
}
