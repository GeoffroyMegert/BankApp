package ch.hearc.ig.odi.bankapp.presentation.bean;

import ch.hearc.ig.odi.bankapp.business.Account;
import ch.hearc.ig.odi.bankapp.business.Customer;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

/**
 * Cette classe est un Backing Bean lié à la page "customerDetail.xhtml".
 * Elle permet de gérer le client à détailler.
 * 
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
// Le nom du Backing Bean. C'est ce nom qui est employé pour l'appeler depuis d'autres pages.
@Named(value = "customerDetailBean")
// Cycle de vie du Backing Bean.
// Il utilise des objets qui ont besoins de persister plus d'une requête, donc son cycle de vie est d'une session.
@SessionScoped
public class CustomerDetailBean implements Serializable {
    
    /** Le client à détailler. */
    private Customer customer;
    /** La listes des comptes possédés par le client. */
    // Les DataModel sont orientés pour les composants des JavaServer Faces.
    private DataModel<Account> accounts;
    
    /** 
     * Reçoit le client à détailler.
     * 
     * @param customer  Le client à détailler.
     * @return "success" si le client a été reçu, sinon retourne "failure".
     */
    public String getCustomer(final Customer customer) {
        this.customer = customer;
        
        if(customer != null) {
            return "success";
        } else {
            return "failure";
        }
    }
    
    /**
     * Permet d'obtenir la liste des comptes du client.
     * 
     * @return La liste des comptes du client.
     */
    public DataModel<Account> getAccounts() {
        accounts = new ListDataModel<>();
        
        accounts.setWrappedData(customer.getAccounts());
        
        return accounts;
    }

    /**
     * Permet d'obtenir le client à détailler.
     * 
     * @return Le client à détailler.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Modifie le client à détailler par celui passé en paramètre.
     * 
     * @param customer Le nouveau client à détailler.
     */
    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }
    
}
