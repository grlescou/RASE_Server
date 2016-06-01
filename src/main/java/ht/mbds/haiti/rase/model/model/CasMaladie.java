/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import ht.mbds.haiti.rase.utils.DateUtils;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gaetan
 */

import org.springframework.data.mongodb.core.geo.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cas_maladie")
public class CasMaladie  implements Serializable 
{
    @Id
    private String id;
    
    private Maladie maladie;
    @DBRef
    private List<Symptome> listeSymptome;
    @DBRef
    private Utilisateur user ;
    
    private MentionResponsabilite mention; 
    
    private String sexe; // {Femme,Homme,Mixe}
    
    private String groupeAge; // {Moins_de_5 ,Plus_de_5 }
     
    private Date date;
    
    // the coordinates must be stored in the longitude, latitude order
    private List<Double> location;
  
    private int note;
    
    private int nombreCas;
    
    private Zone zone;
    
    public CasMaladie() {
    }
    
    @JsonCreator
    public CasMaladie(@JsonProperty("maladie") Maladie maladie, @JsonProperty("listeSymptome") List<Symptome> listeSymptome,@JsonProperty("user")  Utilisateur user,@JsonProperty("mention") MentionResponsabilite mention,@JsonProperty("sexe") String sexe,@JsonProperty("groupeAge") String groupeAge, @JsonProperty("date")  String date, @JsonProperty("location") List<Double> location, @JsonProperty("note") int note, @JsonProperty("nombreCas") int nombreCas, @JsonProperty("zone") Zone zone) {
        
        //this.categorie = new Categorie();
        //this.categorie.setId( maladie.getCategorie().getId());
       // this.categorie.setNom( maladie.getCategorie().getNom());
        
        //this.categorie.setDescription(null);
        //this.categorie.setListemaladie(null);
        
        
        maladie.setDescription(null);
        maladie.setSymptomes(null);
        this.maladie = maladie;
        
        
        this.listeSymptome = listeSymptome;
        this.user = user;
        
        this.mention = mention;
        this.sexe = sexe ;
        this.groupeAge = groupeAge;
        
        this.date = DateUtils.getDate(DateUtils.getDateFormater(date, DateUtils.DB_FORMAT_DATE,DateUtils.DB_FORMAT_ISO_DATETIME),DateUtils.DB_FORMAT_ISO_DATETIME);
        this.location = location;
        this.note = note;
        this.nombreCas = nombreCas;
        this.zone = zone;
    }
    
    
    @JsonIgnore
    public boolean isNew() {
        return id == null;
    }
    

    public Utilisateur getUser ()
    {
        return user;
    }

    public void setUser (Utilisateur User)
    {
        this.user = User;
    }

    public Maladie getMaladie ()
    {
        return maladie;
    }

    public void setMaladie (Maladie Maladie)
    {
        this.maladie = Maladie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Date getDate ()
    {
        return  this.date;// =DateUtils.getDateFormater(date, DateUtils.DB_FORMAT_DATE,DateUtils.DB_FORMAT_ISO_DATETIME),DateUtils.DB_FORMAT_ISO_DATETIME);
    }

    public void setDate (String date)
    {
        this.date =  this.date = DateUtils.getDate(DateUtils.getDateFormater(date, DateUtils.DB_FORMAT_DATE,DateUtils.DB_FORMAT_ISO_DATETIME),DateUtils.DB_FORMAT_ISO_DATETIME);
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> Location) {
        this.location = Location;
    }

   

    public List<Symptome> getListeSymptome ()
    {
        return listeSymptome;
    }

    public void setListeSymptome (List<Symptome> ListeSymptome)
    {
        this.listeSymptome = ListeSymptome;
    }

    public int getNote ()
    {
        return note;
    }

    public void setNote (int Note)
    {
        this.note = Note;
    }

    public Zone getZone ()
    {
        return zone;
    }

    public void setZone (Zone Zone)
    {
        this.zone = Zone;
    }

    public MentionResponsabilite getMention() {
        return mention;
    }

    public void setMention(MentionResponsabilite mention) {
        this.mention = mention;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getGroupeAge() {
        return groupeAge;
    }

    public void setGroupeAge(String groupeAge) {
        this.groupeAge = groupeAge;
    }

    public int getNombreCas() {
        return nombreCas;
    }

    public void setNombreCas(int nombreCas) {
        this.nombreCas = nombreCas;
    }
    
    
    
    

    @Override
    public String toString()
    {
        return "CasMaladie [User = "+user+", Maladie = "+maladie+", _id = "+id+", Date = "+date+", Location = "+location+", Symptome = "+listeSymptome+", Note = "+note+", Zone = "+zone+"]";
    }
    
    
}