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
import java.util.List;

/**
 *
 * @author MyPC
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
     @DBRef
    private Maladie maladie;
     @DBRef
    private List<Symptome> listeSymptome;
     @DBRef
    private PersonnelSante user ;
     
    private String date;
    
    // the coordinates must be stored in the longitude, latitude order
    private List<Double> location;

    
    private int note;
    
    private Zone zone;
    
    public CasMaladie() {
    }
    
    @JsonCreator
    public CasMaladie( @JsonProperty("maladie") Maladie maladie, @JsonProperty("listeSymptome") List<Symptome> listeSymptome,@JsonProperty("user")  PersonnelSante user, @JsonProperty("date")  String date, @JsonProperty("location") List<Double> location, @JsonProperty("note") int note, @JsonProperty("zone") Zone zone) {
        this.maladie = maladie;
        this.listeSymptome = listeSymptome;
        this.user = user;
        this.date = date;
        this.location = location;
        this.note = note;
        this.zone = zone;
    }
    
    
    @JsonIgnore
    public boolean isNew() {
        return id == null;
    }
    

    public PersonnelSante getUser ()
    {
        return user;
    }

    public void setUser (PersonnelSante User)
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


    public String getDate ()
    {
        return date;
    }

    public void setDate (String Date)
    {
        this.date = Date;
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

    @Override
    public String toString()
    {
        return "CasMaladie [User = "+user+", Maladie = "+maladie+", _id = "+id+", Date = "+date+", Location = "+location+", Symptome = "+listeSymptome+", Note = "+note+", Zone = "+zone+"]";
    }
    
    
}