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
@Document(collection = "maladie")
public class Maladie implements Serializable 
{
    @Id
    private Long id;
    private String nom;
    private String description;
    private int  seuil ;
    
    public Maladie() {
    }

    public Maladie(String nom, String description, int seuil) {
        this.nom = nom;
        this.description = description;
        this.seuil = seuil;
    }

    public Maladie(long _id, String nom, String description, int seuil) {
        this.id = _id;
        this.nom = nom;
        this.description = description;
        this.seuil = seuil;
    }

   

    public long getId() {
        return id;
    }

    public void setId(long _id) {
        this.id = _id;
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

    public int getSeuil() {
        return seuil;
    }

    public void setSeuil(int seuil) {
        this.seuil = seuil;
    }

    @Override
    public String toString() {
        return "Maladie{" + "_id=" + id + ", nom=" + nom + ", description=" + description + ", seuil=" + seuil + '}';
    }

    
    
    
}
			
			