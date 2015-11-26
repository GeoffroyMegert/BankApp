/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.bankapp.presentation.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
@Named("AccountDetailBean")
@RequestScoped
public class AccountDetailBean {
    
    private int id;
    private String label;
    private double balance;
    private double rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    
}
