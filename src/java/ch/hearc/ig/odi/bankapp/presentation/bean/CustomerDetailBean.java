package ch.hearc.ig.odi.bankapp.presentation.bean;

import ch.hearc.ig.odi.bankapp.business.Account;
import ch.hearc.ig.odi.bankapp.business.Customer;
import ch.hearc.ig.odi.bankapp.services.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
@Named("CustomerDetailBean")
@RequestScoped
public class CustomerDetailBean implements Serializable {
    
    private Customer customer;
    private DataModel<Account> accounts;
    
    @Inject
    private Services services;

    public String getCustomer(final int id) {
        customer = services.getCustomer(id);
        
        return "success";
    }
    
    public DataModel<Account> getAccounts() {
        accounts = new ListDataModel<>();
        
        accounts.setWrappedData(customer.getAccounts());
        
        return accounts;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
