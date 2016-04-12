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
@Document(collection = "souscription")
public class Souscription {
   
    @Id
    private String _id ;
    private String nom;
    private String prenom;
    private String titre;
    private String email;
    private String code;
    private boolean actif;

    @JsonCreator
    public Souscription(@JsonProperty("_id") String _id,@JsonProperty("nom")  String nom,@JsonProperty("prenom")  String prenom,@JsonProperty("titre")  String titre,@JsonProperty("email") String email,@JsonProperty("code") String code,@JsonProperty("actif") boolean actif) {
        
       
        this._id = _id;
        this.nom = nom;
        this.prenom = prenom;
        this.titre = titre;
        this.email = email;
        this.code = code;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    
    
    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
            
    
           
}
