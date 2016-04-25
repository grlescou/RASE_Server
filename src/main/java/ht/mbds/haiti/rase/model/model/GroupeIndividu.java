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
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author gaetan
 */
@Document(collection = "groupe_individu")
public class GroupeIndividu implements Serializable {
    
    @Id 
    private String _id;
    private String nomGroupe;
    private String description;
    
    @DBRef
    private List<MentionResponsabilite>  listeMention= new ArrayList<MentionResponsabilite>();

    public GroupeIndividu() {
    }

    
    
     @JsonCreator
    public GroupeIndividu(@JsonProperty("nomGroupe") String nomGroupe,@JsonProperty("description")  String description) {
        this.nomGroupe = nomGroupe;
        this.description = description;
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

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MentionResponsabilite> getListeMention() {
        return listeMention;
    }

    public void setListeMention(List<MentionResponsabilite> listeMention) {
        this.listeMention = listeMention;
    }
    
    
    
      public void addMention(MentionResponsabilite newMentionResponsabilite){
         this.listeMention.add(newMentionResponsabilite);
    }
    
    public void removeMention(MentionResponsabilite removeMentionResponsabilite)
    {
         this.listeMention.remove(removeMentionResponsabilite);
    }

    @Override
    public String toString() {
        return "GroupeIndividu{" + "_id=" + _id + ", nomGroupe=" + nomGroupe + ", description=" + description + ", listeMention=" + listeMention + '}';
    }
    
    
    
}
