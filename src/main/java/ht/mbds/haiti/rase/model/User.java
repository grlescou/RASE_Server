/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model;


import java.io.Serializable;
import org.springframework.data.mongodb.core.geo.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 *
 * @author MyPC
 */
@Document(collection = "user")
public class User  implements Serializable 
{
    @Id
    private String _id;
    private String prenom;
    private String nom;
    private String mail;
    private String password;
    private Profession Profession;
    //private String Telephone ;
    // private Adresse adresse ;
    private GeoJsonPoint DernierLocation;
    private boolean actif;
    private String ip;
    private boolean valider ;
    
    public User() {
    }

    public User(String prenom, String nom, String mail, String password, Profession Profession, boolean actif) {
        this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.password = password;
        this.Profession = Profession;
        this.actif = actif;
        this.valider = false;
    }

    public User(String _id, String prenom, String nom, String mail, String password, Profession Profession, GeoJsonPoint DernierLocation, boolean actif, String ip, boolean valider) {
        this._id = _id;
        this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.password = password;
        this.Profession = Profession;
        this.DernierLocation = DernierLocation;
        this.actif = actif;
        this.ip = ip;
        this.valider = valider;
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

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    public Profession getProfession ()
    {
        return Profession;
    }

    public void setProfession (Profession Profession)
    {
        this.Profession = Profession;
    }

    public GeoJsonPoint getDernierLocation ()
    {
        return DernierLocation;
    }

    public void setDernierLocation (GeoJsonPoint DernierLocation)
    {
        this.DernierLocation = DernierLocation;
    }

    public boolean getActif ()
    {
        return actif;
    }

    public void setActif (boolean actif)
    {
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
    public String toString()
    {
        return "User [prenom = "+prenom+", mail = "+mail+", _id = "+_id+", Profession = "+Profession+", DernierLocation = "+DernierLocation+", actif = "+actif+", nom = "+nom+", ip = "+ip+"]";
    }
}
	
