/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.model;



/**
 *
 * @author gaetan
 */
public class Adresse {
    private String rue;
    private String commune ;
    private String departement;

    public Adresse(String rue, String commune, String departement) {
        this.rue = rue;
        this.commune = commune;
        this.departement = departement;
    }

    public Adresse() {
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "Adresse{" + "rue=" + rue + ", commune=" + commune + ", departement=" + departement + '}';
    }
  
    
    
}
