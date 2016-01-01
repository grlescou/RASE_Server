/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 *
 * @author MyPC
 */
@Document(collection = "profession")
public class Profession implements Serializable 
{
    @Id 
    private String id;
    private String nom;
    private String description;

   

    public Profession() {
    }

    /*
    public Profession(String id, String nom, String description) {
        this.id = id;
        this.description = description;
        this.nom = nom;
    }
*/
    @JsonCreator
    public Profession(@JsonProperty("nom") String nom, @JsonProperty("description") String description) {
        this.description = description;
        this.nom = nom;
    }

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
        return "Profession [_id = "+id+", description = "+description+", nom = "+nom+"]";
    }
}
