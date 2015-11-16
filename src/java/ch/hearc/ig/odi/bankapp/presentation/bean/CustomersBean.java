package ch.hearc.ig.odi.bankapp.presentation.bean;

import ch.hearc.ig.odi.bankapp.business.Customer;
import ch.hearc.ig.odi.bankapp.services.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

/**
 *
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
@Named("CustomersBean")
@RequestScoped
public class CustomersBean implements Serializable {
    
    private DataModel<Customer> customers;
    
    public DataModel<Customer> getCustomers() {
        customers = new ListDataModel<>();
        customers.setWrappedData(new Services().getCustomersList());
        return customers;
    }
}
