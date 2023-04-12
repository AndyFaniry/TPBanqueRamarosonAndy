/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanqueramarosonandy.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import mg.itu.tpbanqueramarosonandy.ejb.GestionnaireCompte;
import mg.itu.tpbanqueramarosonandy.entites.CompteBancaire;

/**
 *
 * @author ramar
 */
@Named(value = "transfert")
@RequestScoped
public class Transfert {
    
    @EJB
    private GestionnaireCompte gestionnaireCompte;
    
    private Long idSource;
    
    private Long idDestination;
    
    private int montant;

    /**
     * Get the value of montant
     *
     * @return the value of montant
     */
    public int getMontant() {
        return montant;
    }

    /**
     * Set the value of montant
     *
     * @param montant new value of montant
     */
    public void setMontant(int montant) {
        this.montant = montant;
    }


    /**
     * Get the value of idDestination
     *
     * @return the value of idDestination
     */
    public Long getIdDestination() {
        return idDestination;
    }

    /**
     * Set the value of idDestination
     *
     * @param idDestination new value of idDestination
     */
    public void setIdDestination(Long idDestination) {
        this.idDestination = idDestination;
    }


    /**
     * Get the value of idSource
     *
     * @return the value of idSource
     */
    public Long getIdSource() {
        return idSource;
    }

    /**
     * Set the value of idSource
     *
     * @param idSource new value of idSource
     */
    public void setIdSource(Long idSource) {
        this.idSource = idSource;
    }


    /**
     * Creates a new instance of Transfert
     */
    public Transfert() {
    }
    
    
    public String transferer(){
        CompteBancaire source = gestionnaireCompte.findById(idSource);
        CompteBancaire destination = gestionnaireCompte.findById(idDestination);
        gestionnaireCompte.transferer(source, destination, montant);
        return "listeComptes?faces-redirect=true";
    }
}
