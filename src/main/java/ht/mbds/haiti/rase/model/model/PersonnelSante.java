/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author gaetan
 */
@Document(collection = "utilisateur")
public class PersonnelSante extends Utilisateur implements Serializable {
    
    @DBRef
    private Profession profession;
    // the coordinates must be stored in the longitude, latitude order
    private List<Double> dernierLocation;
    private String status ;  // "En Cours", "Accepter" , "Rejeter"

    public PersonnelSante() {
    }


    @JsonCreator
    public PersonnelSante(@JsonProperty("prenom") String prenom, @JsonProperty("nom") String nom, @JsonProperty("mail") String mail, @JsonProperty("password") String password, @JsonProperty("role") String role, @JsonProperty("telephone") String telephone, @JsonProperty("adresse") Adresse adresse,  @JsonProperty("actif") boolean actif, @JsonProperty("ip")  String ip, @JsonProperty("profession") Profession profession,  @JsonProperty("dernierLocation")   List<Double> dernierLocation, @JsonProperty("status") String status) {
        super(prenom, nom, mail, password, role, telephone, adresse, actif, ip);
        this.profession = profession;
        this.dernierLocation = dernierLocation;
        this.status = status;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public List<Double> getDernierLocation() {
        return dernierLocation;
    }

    public void setDernierLocation(List<Double> dernierLocation) {
        this.dernierLocation = dernierLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
    
    
}
