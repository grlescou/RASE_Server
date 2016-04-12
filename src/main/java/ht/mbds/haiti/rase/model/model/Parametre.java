/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author gaetan
 */
@Document(collection = "parametre")
public class Parametre {
   
    @Id
    private String _id ;
    private String nom;
    private String value;
    private boolean actif;

    @JsonCreator
    public Parametre( @JsonProperty("_id") String _id, @JsonProperty("nom") String nom, @JsonProperty("value")  String value, @JsonProperty("actif") boolean actif) {
        this._id = _id;
        this.nom = nom;
        this.value = value;
        this.actif = actif;
    }
    
     @JsonIgnore
    public boolean isNew() {
        return _id == null;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
    
    
}
