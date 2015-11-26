/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.bankapp.presentation.bean;

import ch.hearc.ig.odi.bankapp.business.Account;
import ch.hearc.ig.odi.bankapp.business.Customer;
import ch.hearc.ig.odi.bankapp.services.Services;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
@Named("AccountDetailBean")
@SessionScoped
public class AccountDetailBean implements Serializable {
    
    private Account account;
    
    @Inject
    private Services services;

    public String getAccount(final int customerId, final String accountId) {
        Customer customer = services.getCustomer(customerId);
        account = customer.getAccountByNumber(accountId);
        
        return "success";
    } 
    
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
}
