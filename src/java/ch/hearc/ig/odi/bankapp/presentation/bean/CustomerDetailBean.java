package ch.hearc.ig.odi.bankapp.presentation.bean;

import ch.hearc.ig.odi.bankapp.business.Account;
import ch.hearc.ig.odi.bankapp.business.Customer;
import ch.hearc.ig.odi.bankapp.services.Services;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Cette classe est un Backing Bean lié à la page "customerDetail.xhtml".
 * Elle permet de gérer l'affichage du détail d'un client.
 * 
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
// Le nom du Backing Bean. C'est ce nom qui est employé pour l'appeler depuis d'autres pages.
@Named("CustomerDetailBean")
// Cycle de vie du Backing Bean.
// Il utilise des objets qui ont besoins de persister plus d'une requête, donc son cycle de vie est d'une session.
@SessionScoped
public class CustomerDetailBean implements Serializable {
    
    /** Le client à détailler. */
    private Customer customer;
    /** La listes des comptes possédés par le client. */
    // Les DataModel sont orientés pour les composants des JavaServer Faces.
    private DataModel<Account> accounts;
    
    /** Services mises à disposition du programmeur. */
    // Gère automatiquement l'instanciation de l'attribut "services".
    @Inject
    private Services services;

    /** 
     * Recherche le client au sein de la banque.
     * 
     * @param id Le numéro du client désiré.
     * @return "success" si le client a été trouvé, sinon retourne "failure".
     */
    public String getCustomer(final int id) {
        customer = services.getCustomer(id);
        
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
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
