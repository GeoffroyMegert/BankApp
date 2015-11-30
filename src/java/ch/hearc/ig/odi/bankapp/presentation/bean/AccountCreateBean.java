package ch.hearc.ig.odi.bankapp.presentation.bean;

import ch.hearc.ig.odi.bankapp.business.Account;
import ch.hearc.ig.odi.bankapp.business.Customer;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
@Named("AccountCreateBean")
@SessionScoped
public class AccountCreateBean implements Serializable {
    
    private String number;
    private String name;
    private double balance;
    private double rate;
    private Customer customer;
    
    public String submit() {
        Account account = customer.addAccount(number, name, rate);
        
        if(account != null) {
            account.setBalance(balance);
            return "success";
        } else {
            return "failure";
        }
    }
    
    public String getCustomer(final Customer customer) {
        if(customer != null) {
            this.customer = customer;
            return "success";
        } else {
            return "failure";
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(final double balance) {
        this.balance = balance;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(final double rate) {
        this.rate = rate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }
    
}
