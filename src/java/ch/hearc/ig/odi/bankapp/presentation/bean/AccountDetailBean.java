package ch.hearc.ig.odi.bankapp.presentation.bean;

import ch.hearc.ig.odi.bankapp.business.Account;
import ch.hearc.ig.odi.bankapp.business.Customer;
import ch.hearc.ig.odi.bankapp.services.Services;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Cette classe est un Backing Bean lié à la page "accountDetail.xhtml".
 * Elle permet de gérer le compte à détailler.
 * 
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
// Le nom du Backing Bean. C'est ce nom qui est employé pour l'appeler depuis d'autres pages.
@Named("AccountDetailBean")
// Cycle de vie du Backing Bean.
// Il utilise des objets qui ont besoins de persister plus d'une requête, donc son cycle de vie est d'une session.
@SessionScoped
public class AccountDetailBean implements Serializable {
    
    /** Le compte à détailler. */
    private Account account;
    
    /** Services mises à disposition du programmeur. */
    // Gère automatiquement l'instanciation de l'attribut "services".
    @Inject
    private Services services;

    /**
     * Recherche le compte parmi ceux possédés par le client.
     * 
     * @param customerId Le numéro du client propriétaire du compte.
     * @param accountId Le numéro du compte recherché.
     * @return "success" si le client a été trouvé, sinon retourne "failure".
     */
    public String getAccount(final int customerId, final String accountId) {
        Customer customer = services.getCustomer(customerId);
        account = customer.getAccountByNumber(accountId);
        
        if(account != null) {
            return "success";
        } else {
            return "failure";
        }
    } 
    
    /**
     * Permet d'obtenir le compte à détailler.
     * 
     * @return Le compte à détailler.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Modifie le compte à détailler par celui passé en paramètre.
     * 
     * @param account Le nouveau compte à détailler.
     */
    public void setAccount(Account account) {
        this.account = account;
    }
    
}
