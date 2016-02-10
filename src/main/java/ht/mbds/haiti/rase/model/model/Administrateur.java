/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author gaetan
 */
@Document(collection = "utilisateur")
public class Administrateur extends Utilisateur implements Serializable {
  
    private String typeAdmin;

    public Administrateur() {
    }

     @JsonCreator
    public Administrateur( @JsonProperty("prenom") String prenom, @JsonProperty("nom") String nom, @JsonProperty("mail") String mail, @JsonProperty("password") String password, @JsonProperty("role") String role, @JsonProperty("telephone") String telephone, @JsonProperty("adresse") Adresse adresse,  @JsonProperty("actif") boolean actif, @JsonProperty("ip")  String ip, @JsonProperty("typeAdmin") String typeAdmin) {
        super(prenom, nom, mail, password, role, telephone, adresse, actif, ip);
        this.typeAdmin = typeAdmin;
    }
    

    
    public String getTypeAdmin() {
        return typeAdmin;
    }
   

    public void setTypeAdmin(String typeAdmin) {
        this.typeAdmin = typeAdmin;
    }
    
    
}
