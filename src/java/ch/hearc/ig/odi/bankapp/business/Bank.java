package ch.hearc.ig.odi.bankapp.business;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Cette classe permet la gestion de banques.
 * 
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
public class Bank {

    /** Le numéro de la banque. */
    private int number;
    /** Le nom de la banque. */
    private String name;
    /** La liste des clients enregistrés auprès de la banque. */
    private Map<Integer, Customer> customers;
    /** La liste des comptes ouverts au sein de la banque. */
    private Map<String, Account> accounts;

    /**
     * Constructeur paramétré pour les banques.
     *
     * @param number Le numéro de la banque.
     * @param name Le nom de la banque.
     */
    public Bank(final int number, final String name) {
        this.number = number;
        this.name = name;
        this.customers = new HashMap<>();
        this.accounts = new HashMap<>();
    }

    /**
     * Cherche le compte ayant le numéro donné.
     *
     * @param number Le numéro du compte désiré.
     * @return Le compte recherché ou null s'il n'existe pas.
     */
    public Account getAccountByNumber(final String number) {
        return this.accounts.get(number);
    }

    /**
     * Recherche le client ayant le numéro donné.
     * 
     * @param number Le numéro du client désiré.
     * @return Le client recherché ou null s'il n'existe pas.
     */
    public Customer getCustomerByNumber(final int number) {
        return this.customers.get(number);
    }
    
    /**
     * Envoie la liste des clients de la banque.
     * 
     * @return La liste des clients de la banque.
     */
    public Map<Integer, Customer> getCustomers() {
        return this.customers;
    }

    /**
     * Ajoute un client à la banque.
     * 
     * @param number Le numéro du nouveau client.
     * @param firstName Le prénom du nouveau client.
     * @param lastName Le nom du nouveau du client.
     * @return Le client nouvellement enregistré auprès de la banque.
     */
    public Customer addCustomer(final int number, final String firstName, final String lastName) {
        Customer customer = new Customer(number, firstName, lastName);
        this.customers.put(number, customer);
        return customer;
    }

    /**
     * Ajoute un compte à la banque.
     * 
     * @param number Le numéro du nouveau compte.
     * @param name Le nom du nouveau compte.
     * @param rate Le taux d'intérêt du nouveau compte.
     * @param customer Le propriétaire du compte.
     * @throws IllegalArgumentException si le client n'est pas enregistré auprès de la banque.
     */
    public void addAccount(final String number, final String name, final double rate, final Customer customer) {
        if(getCustomerByNumber(customer.getNumber()) == null) {
            throw new IllegalArgumentException("Le client n'est pas enregistré au près de la banque.");
        }
        
        this.accounts.put(number, new Account(number, name, rate, customer));
        customer.addAccount(number, name, rate);
    }
    
    /**
     * Permet d'obtenir le numéro de la banque.
     * 
     * @return Le numéro de la banque.
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Modifie le numéro de la banque par celui passé en paramètre.
     * 
     * @param number Le nouveau numéro de la banque.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Permet d'obtenir le nom de la banque.
     * 
     * @return Le nom de la banque.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Modifie le nom de la banque par celui passé en paramètre.
     * 
     * @param name Le nouveau nom de la banque.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(this.number);
        sb.append(";");
        sb.append(this.name);
        
        for(Iterator cust = customers.values().iterator(); cust.hasNext();) {
            sb.append(";");
            sb.append(((Customer)cust.next()).toString());
        }
        
        for(Iterator acc = accounts.values().iterator(); acc.hasNext();) {
            sb.append(";");
            sb.append(((Account)acc.next()).toString());
        }
        
        return sb.toString();
    }
}
