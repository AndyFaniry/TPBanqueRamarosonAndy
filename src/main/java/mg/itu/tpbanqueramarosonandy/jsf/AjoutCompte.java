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
import mg.itu.tpbanqueramarosonandy.jsf.util.Util;

/**
 *
 * @author ramar
 */
@Named(value = "ajoutCompte")
@RequestScoped
public class AjoutCompte {

    @EJB
    private GestionnaireCompte gestionnaireCompte;

    private String nom;

    private int solde;

    /**
     * Get the value of solde
     *
     * @return the value of solde
     */
    public int getSolde() {
        return solde;
    }

    /**
     * Set the value of solde
     *
     * @param solde new value of solde
     */
    public void setSolde(int solde) {
        this.solde = solde;
    }

    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the value of nom
     *
     * @param nom new value of nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Creates a new instance of AjoutCompte
     */
    public AjoutCompte() {
    }

    public String action() {
        boolean erreur = false;
        if (solde < 0) {
            Util.messageErreur("Solde négatif!", "Solde négatif !", "formAjout:solde");
            erreur = true;
        }
        if (erreur) {
            return null;
        }
        CompteBancaire c = new CompteBancaire(nom, solde);
        gestionnaireCompte.creerCompte(c);
        Util.addFlashInfoMessage("Compte créé");

        return "listeComptes?faces-redirect=true";
    }
}
