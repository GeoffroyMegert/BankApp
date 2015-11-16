package ch.hearc.ig.odi.bankapp.presentation.bean;

import ch.hearc.ig.odi.bankapp.services.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
@Named("CustomerCreateBean")
@RequestScoped
public class CustomerCreateBean implements Serializable {
    
    private int id;
    private String firstName;
    private String lastName;
    
    public void submit() {
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        
//        int id = Integer.valueOf(request.getParameter("createCustomer:id"));
//        String firstName = request.getParameter("createCustomer:firstname");
//        String lastName = request.getParameter("createCustomer:lastname");
        
        new Services().saveCustomer(id, firstName, lastName);
        
        request.getRequestDispatcher("faces/createCustomerOk.xhtml");
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
