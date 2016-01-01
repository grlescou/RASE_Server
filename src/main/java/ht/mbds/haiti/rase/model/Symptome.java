/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model;

import java.io.Serializable;
import org.springframework.data.mongodb.core.geo.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import java.util.List;

/**
 *
 * @author MyPC
 */

@Document(collection = "symptome")
public class Symptome  implements Serializable 
{
    @Id
    private String id;
    private String nom;
    private String description;

    public Symptome() {
    }

    @JsonCreator
    public Symptome(@JsonProperty("nom") String nom, @JsonProperty("description") String description) {
        this.nom = nom;
        this.description = description;
    }

    /*
    public Symptome(String _id, String nom, String description) {
        this.id = _id;
        this.nom = nom;
        this.description = description;
    }

    */
     @JsonIgnore
    public boolean isNew() {
        return id == null;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   

   

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getNom ()
    {
        return nom;
    }

    public void setNom (String nom)
    {
        this.nom = nom;
    }

    @Override
    public String toString()
    {
        return "Symptome [_id = "+id+", description = "+description+", nom = "+nom+"]";
    }
}
