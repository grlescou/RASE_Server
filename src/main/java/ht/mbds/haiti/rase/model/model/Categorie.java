/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author gaetan
 */
@Document(collection = "categorie")
public class Categorie implements Serializable {
    @Id
    private String id;
    private String nom;
    private String description;
    @DBRef
    private Maladie maladie;

    
    public Categorie() {
    }
    @JsonCreator
    public Categorie(@JsonProperty("nom") String nom, @JsonProperty("description") String description) {
        this.nom = nom;
        this.description = description;
       
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", nom=" + nom + ", description=" + description +  '}';
    }

}
