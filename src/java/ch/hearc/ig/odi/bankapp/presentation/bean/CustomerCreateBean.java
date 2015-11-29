package ch.hearc.ig.odi.bankapp.presentation.bean;

import ch.hearc.ig.odi.bankapp.services.Services;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Cette classe est un Backing Bean lié à la page "createCustomer.xhtml".
 * 
 * @author Geoffroy Megert <geoffroy.megert@he-arc.ch>
 */
// Le nom du Backing Bean. C'est ce nom qui est employé pour l'appeler depuis d'autres pages.
@Named("CustomerCreateBean")
// Cycle de vie du Backing Bean.
// Il modifie des objets qui ont besoins de persister plus d'une requête, donc son cycle de vie est d'une session.
@SessionScoped
public class CustomerCreateBean implements Serializable {
    
    /** Le numéro du nouveau client. */
    private int id;
    /** Le prénom du nouveau client. */
    private String firstName;
    /** Le nom du nouveau client. */
    private String lastName;
    
    /** Services mises à disposition du programmeur. */
    // Gère automatiquement l'instanciation de l'attribut "services".
    @Inject
    private Services services;
    
    /**
     * Effectuer l'enregistrement du nouveau client auprès de la banque.
     * 
     * @return "success" pour signaler le succès de l'enregistrement.
     */
    public String submit() {
        services.saveCustomer(id, firstName, lastName);
        
        return "success";
    }

    /**
     * Permet d'obtenir le numéro du nouveau client.
     * 
     * @return Le numéro du nouveau client.
     */
    public int getId() {
        return id;
    }

    /**
     * Modifie le numéro du nouveau client par celui passé en paramètre.
     * 
     * @param id Le nouveau numéro du client.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Permet d'obtenir le prénom du nouveau client.
     * 
     * @return Le prénom du nouveau client.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Modifie le prénom du nouveau client par celui passé en paramètre.
     * 
     * @param firstName Le nouveau prénom du client.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Permet d'obtenir le nom du nouveau client.
     * 
     * @return Le nom du nouveau client.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Modifie le nom du nouveau client par celui passé en paramètre.
     * 
     * @param lastName Le nouveau nom du client.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    
}
