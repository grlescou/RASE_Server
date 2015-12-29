/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model;

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
    private String _id;
    private String nom;
    private String description;

   

    public Profession() {
    }

    public Profession(String _id, String nom, String description) {
        this._id = _id;
        this.description = description;
        this.nom = nom;
    }

    public Profession( String nom,String description) {
        this.description = description;
        this.nom = nom;
    }

    
    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
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
        return "Profession [_id = "+_id+", description = "+description+", nom = "+nom+"]";
    }
}
