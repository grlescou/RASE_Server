/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author MyPC
 */

import org.springframework.data.mongodb.core.geo.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cas_maladie")
public class CasMaladie  implements Serializable 
{
    @Id
    private String _id;
    
    private Maladie Maladie;
    
    private List<Symptome> ListeSymptome;
    
    private User User;
 
    private String Date;

    private GeoJsonPoint Location;

   
    private int Note;

    private Zone Zone;

    public CasMaladie() {
    }

    public CasMaladie(Maladie Maladie, List<Symptome> ListeSymptome, User User, String Date, GeoJsonPoint Location, int Note, Zone Zone) {
        this.Maladie = Maladie;
        this.ListeSymptome = ListeSymptome;
        this.User = User;
        this.Date = Date;
        this.Location = Location;
        this.Note = Note;
        this.Zone = Zone;
    }
    
    
    
    

    public User getUser ()
    {
        return User;
    }

    public void setUser (User User)
    {
        this.User = User;
    }

    public Maladie getMaladie ()
    {
        return Maladie;
    }

    public void setMaladie (Maladie Maladie)
    {
        this.Maladie = Maladie;
    }

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    public String getDate ()
    {
        return Date;
    }

    public void setDate (String Date)
    {
        this.Date = Date;
    }

    public GeoJsonPoint getLocation ()
    {
        return Location;
    }

    public void setLocation (GeoJsonPoint Location)
    {
        this.Location = Location;
    }

    public List<Symptome> getListeSymptome ()
    {
        return ListeSymptome;
    }

    public void setListeSymptome (List<Symptome> ListeSymptome)
    {
        this.ListeSymptome = ListeSymptome;
    }

    public int getNote ()
    {
        return Note;
    }

    public void setNote (int Note)
    {
        this.Note = Note;
    }

    public Zone getZone ()
    {
        return Zone;
    }

    public void setZone (Zone Zone)
    {
        this.Zone = Zone;
    }

    @Override
    public String toString()
    {
        return "CasMaladie [User = "+User+", Maladie = "+Maladie+", _id = "+_id+", Date = "+Date+", Location = "+Location+", Symptome = "+ListeSymptome+", Note = "+Note+", Zone = "+Zone+"]";
    }
}