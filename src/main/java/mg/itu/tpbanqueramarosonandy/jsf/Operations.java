/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanqueramarosonandy.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import mg.itu.tpbanqueramarosonandy.ejb.GestionnaireCompte;
import mg.itu.tpbanqueramarosonandy.entites.CompteBancaire;

/**
 *
 * @author ramar
 */
@Named(value = "operations")
@ViewScoped
public class Operations implements Serializable{

    @EJB
  private GestionnaireCompte gestionnaireCompte;
  
    private CompteBancaire compteBancaire;

    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteBancaire getCompteBancaire() {
        return compteBancaire;
    }

    public void setCompteBancaire(CompteBancaire compteBancaire) {
        this.compteBancaire = compteBancaire;
    }

    public void loadOperations() {
        compteBancaire = gestionnaireCompte.findById(id);
    }
}
