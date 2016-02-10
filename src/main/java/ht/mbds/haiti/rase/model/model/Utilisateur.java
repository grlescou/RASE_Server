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
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author gaetan
 */
@Document(collection = "utilisateur")
public abstract class Utilisateur implements Serializable {
    
    @Id
    private String id;
    private String prenom;
    private String nom;
    private String mail;
    private String password;
    private String role; 
    private String telephone ;
    private Adresse adresse ;
    private boolean actif;
    private String ip;

    public Utilisateur() {
    }

    @JsonCreator
    public Utilisateur(@JsonProperty("prenom") String prenom, @JsonProperty("nom") String nom, @JsonProperty("mail") String mail, @JsonProperty("password") String password, @JsonProperty("role") String role, @JsonProperty("telephone") String telephone, @JsonProperty("adresse") Adresse adresse,  @JsonProperty("actif") boolean actif, @JsonProperty("ip")  String ip) {
        
        this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.password = password;
        this.role = role;
        this.telephone = telephone;
        this.adresse = adresse;
        this.actif = actif;
        this.ip = ip;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", mail=" + mail + ", password=" + password + ", role=" + role + ", Telephone=" + telephone + ", adresse=" + adresse + ", actif=" + actif + ", ip=" + ip + '}';
    }
    
    
    

}
