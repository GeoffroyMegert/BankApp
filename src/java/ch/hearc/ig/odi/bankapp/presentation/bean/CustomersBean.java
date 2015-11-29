package ch.hearc.ig.odi.bankapp.presentation.bean;

import ch.hearc.ig.odi.bankapp.business.Customer;
import ch.hearc.ig.odi.bankapp.services.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Cette classe est un Backing Bean lié à la page "customersList.xhtml".
 * Elle permet de gérer les clients enregistrés auprès d'une banque.
 * 
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
// Le nom du Backing Bean. C'est ce nom qui est employé pour l'appeler depuis d'autres pages.
@Named("CustomersBean")
// Cycle de vie du Backing Bean.
// Il ne modifie pas d'objet, donc son cycle de vie est d'une requête.
@RequestScoped
public class CustomersBean implements Serializable {
    
    /** La liste des clients enregistrés auprès d'une banque. */
    // Les DataModel sont orientés pour les composants des JavaServer Faces.
    private DataModel<Customer> customers;
    
    /** Services mises à disposition du programmeur. */
    // Gère automatiquement l'instanciation de l'attribut "services".
    @Inject
    private Services services;
    
    /**
     * Permet d'obtenir la liste des clients enregistrés auprès d'une banque.
     * 
     * @return La liste des clients enregistrés auprès d'une banque.
     */
    public DataModel<Customer> getCustomers() {
        customers = new ListDataModel<>();
        customers.setWrappedData(services.getCustomersList());
        return customers;
    }
}
