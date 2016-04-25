/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.model;


import java.io.Serializable;
import org.springframework.data.mongodb.core.geo.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import java.util.List;
import org.springframework.data.geo.Point;
/**
 *
 * @author MyPC
 */
@Document(collection = "utilisateur")
public class User  implements Serializable 
{
    @Id
    private String id;
    private String prenom;
    private String nom;
    private String mail;
    private String password;
    //private String role 
    private MentionResponsabilite profession;
    //private String Telephone ;
    //private Adresse adresse ;
    
    // the coordinates must be stored in the longitude, latitude order
    private List<Double> dernierLocation;
    private boolean actif;
    private String ip;
    private boolean valider ;
    
    public User() {
    }
    
     @JsonCreator
    public User(@JsonProperty("prenom") String prenom, @JsonProperty("nom") String nom, @JsonProperty("mail") String mail, @JsonProperty("password") String password, @JsonProperty("profession") MentionResponsabilite profession, @JsonProperty("dernierLocation")   List<Double> dernierLocation, @JsonProperty("actif") boolean actif, @JsonProperty("ip")  String ip, @JsonProperty("valider") boolean valider) {
        this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.password = password;
        this.profession = profession;
        this.dernierLocation = dernierLocation;
        this.actif = actif;
        this.ip = ip;
        this.valider = valider;
    }
/*
    public User(String _id, String prenom, String nom, String mail, String password, MentionResponsabilite profession, GeoJsonPoint DernierLocation, boolean actif, String ip, boolean valider) {
        this.id = _id;
        this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.password = password;
        this.profession = profession;
        this.DernierLocation = dernierLocation;
        this.actif = actif;
        this.ip = ip;
        this.valider = valider;
    }
*/
 
    @JsonIgnore
    public boolean isNew() {
        return id == null;
    }

     
    public String getPrenom ()
    {
        return prenom;
    }

    public void setPrenom (String prenom)
    {
        this.prenom = prenom;
    }

    public String getMail ()
    {
        return mail;
    }

     public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    public void setMail (String mail)
    {
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   

    public boolean isValider() {
        return valider;
    }

    public void setValider(boolean valider) {
        this.valider = valider;
    }

   

    public MentionResponsabilite getProfession ()
    {
        return profession;
    }

    public void setProfession (MentionResponsabilite profession)
    {
        this.profession = profession;
    }

    public List<Double> getDernierLocation() {
        return dernierLocation;
    }

    public void setDernierLocation(List<Double> dernierLocation) {
        this.dernierLocation = dernierLocation;
    }



    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

  

    public String getNom ()
    {
        return nom;
    }

    public void setNom (String nom)
    {
        this.nom = nom;
    }

    public String getIp ()
    {
        return ip;
    }

    public void setIp (String ip)
    {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", mail=" + mail + ", password=" + password + ", Profession=" + profession + ", DernierLocation=" + dernierLocation + ", actif=" + actif + ", ip=" + ip + ", valider=" + valider + '}';
    }


}
	
