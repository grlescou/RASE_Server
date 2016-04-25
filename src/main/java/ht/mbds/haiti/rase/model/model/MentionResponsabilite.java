/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 *
 * @author gaetan
 */
@Document(collection = "mention")
public class MentionResponsabilite implements Serializable 
{
    @Id 
    private String id;
    private String nom;
    private String description;
    private GroupeIndividu groupeIndividu;

    public MentionResponsabilite() {
    }

    /*
    public MentionResponsabilite(String id, String nom, String description) {
        this.id = id;
        this.description = description;
        this.nom = nom;
    }
*/
    @JsonCreator
    public MentionResponsabilite(@JsonProperty("nom") String nom, @JsonProperty("description") String description,@JsonProperty("groupeIndividu") GroupeIndividu groupeIndividu) {
        this.description = description;
        this.nom = nom;
        this.groupeIndividu = groupeIndividu;
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

    public GroupeIndividu getGroupeIndividu() {
        return groupeIndividu;
    }

    public void setGroupeIndividu(GroupeIndividu groupeIndividu) {
        this.groupeIndividu = groupeIndividu;
    }
    
    

    @Override
    public String toString()
    {
        return "MentionResponsabilite [_id = "+id+", description = "+description+", nom = "+nom+"]";
    }
}
