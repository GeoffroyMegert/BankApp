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
    
    public void submit() {
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        
        int id = Integer.valueOf(request.getParameter("createCustomer:id"));
        String firstName = request.getParameter("createCustomer:firstname");
        String lastName = request.getParameter("createCustomer:lastname");
        
        new Services().saveCustomer(id, firstName, lastName);
        
        request.getRequestDispatcher("faces/createCustomerOk.xhtml");
    }
}
