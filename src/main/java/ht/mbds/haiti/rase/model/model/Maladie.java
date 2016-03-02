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
 * @author MyPC
 */
@Document(collection = "maladie")
public class Maladie implements Serializable 
{
    @Id
    private String id;
    private String nom;
    private String description;
    private double  seuil;
    private String typeSeuil;
    
    @DBRef
    private Categorie categorie;
    @DBRef
    private List<Symptome> symptomes= new ArrayList<>();
    
    public Maladie() {
    }
    
    @JsonCreator
    public Maladie(@JsonProperty("nom") String nom, @JsonProperty("description") String description, @JsonProperty("seuil") int seuil,  @JsonProperty("typeSeuil") String typeSeuil,@JsonProperty("categorie") Categorie categorie) {
        this.nom = nom;
        this.description = description;
        this.seuil = seuil;
        this.typeSeuil =typeSeuil;
        this.categorie = categorie;
    }
    
/*
    public Maladie(long _id, String nom, String description, int seuil) {
        this.id = _id;
        this.nom = nom;
        this.description = description;
        this.seuil = seuil;
    }

   */

    
    @JsonIgnore
    public boolean isNew() {
        return id == null;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String _id) {
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

    public double getSeuil() {
        return seuil;
    }

    public void setSeuil(double seuil) {
        this.seuil = seuil;
    }

    public String getTypeSeuil() {
        return typeSeuil;
    }

    public void setTypeSeuil(String typeSeuil) {
        this.typeSeuil = typeSeuil;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Symptome> getSymptomes() {
        return symptomes;
    }

    public void setSymptomes(List<Symptome> symptomes) {
        this.symptomes = symptomes;
    }
    
    
    
    public void addSymptome (Symptome newSymptome){
        symptomes.add(newSymptome);
    }
    
    public void removeSymptome(Symptome removeSymptome){
        symptomes.remove(removeSymptome);
    }
    

    @Override
    public String toString() {
        return "Maladie{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", seuil=" + seuil + '}';
    }

    
    
    
}
			
			