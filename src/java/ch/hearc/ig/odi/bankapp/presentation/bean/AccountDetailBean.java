package ch.hearc.ig.odi.bankapp.presentation.bean;

import ch.hearc.ig.odi.bankapp.business.Account;
import ch.hearc.ig.odi.bankapp.business.Customer;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Cette classe est un Backing Bean lié à la page "accountDetail.xhtml".
 * Elle permet de gérer le compte à détailler.
 * 
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
// Le nom du Backing Bean. C'est ce nom qui est employé pour l'appeler depuis d'autres pages.
@Named(value = "accountDetailBean")
// Cycle de vie du Backing Bean.
// Il utilise des objets qui ont besoins de persister plus d'une requête, donc son cycle de vie est d'une session.
@SessionScoped
public class AccountDetailBean implements Serializable {
    
    /** Le compte à détailler. */
    private Account account;
    
    /**
     * Reçoit le compte à détailler parmi ceux possédés par le client.
     * 
     * @param customer Le client propriétaire du compte.
     * @param account Le compte à détailler.
     * @return "success" si le compte a été reçu et qu'il appartient au client souhaité, sinon retourne "failure".
     */
    public String getAccount(final Customer customer, final Account account) {
        if(customer.getAccountByNumber(account.getNumber()) != null) {
            this.account = account;
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
    public void setAccount(final Account account) {
        this.account = account;
    }
    
}
