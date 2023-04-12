/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanqueramarosonandy.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import mg.itu.tpbanqueramarosonandy.ejb.GestionnaireCompte;
import mg.itu.tpbanqueramarosonandy.entites.CompteBancaire;

/**
 *
 * @author ramar
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {
    @EJB
    private GestionnaireCompte gestionnaireCompte;

    private List<CompteBancaire> allComptes;

    /**
     * Get the value of allComptes
     *
     * @return the value of allComptes
     */
    public List<CompteBancaire> getAllComptes() {
        if(allComptes == null) {
            allComptes = gestionnaireCompte.getAllComptes();
        }
        return allComptes;
    }

    /**
     * Creates a new instance of ListeComptes
     */
    public ListeComptes() {
    }

}
