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
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author gaetan
 */
@Document(collection = "notification")
public class Notification implements Serializable {
   
     @Id
    private String id;
    @DBRef
    private HistoriqueDetection alerte;
    private String maladie;
    private String date;
    private String texteDecription;

     @JsonCreator
    public Notification( @JsonProperty("alerte")HistoriqueDetection alerte,@JsonProperty("maladie") String maladie,@JsonProperty("date") String date, @JsonProperty("texteDecription") String texteDecription) {
  
        this.alerte = alerte;
        this.maladie = maladie;
        this.date = date;
        this.texteDecription = texteDecription;
    }
    
    @JsonIgnore
    public boolean isNew() {
        return id == null;
    }
    

    public Notification() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HistoriqueDetection getAlerte() {
        return alerte;
    }

    public void setAlerte(HistoriqueDetection alerte) {
        this.alerte = alerte;
    }

    public String getMaladie() {
        return maladie;
    }

    public void setMaladie(String maladie) {
        this.maladie = maladie;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTexteDecription() {
        return texteDecription;
    }

    public void setTexteDecription(String texteDecription) {
        this.texteDecription = texteDecription;
    }
    
    
    
    
    
    
    
}
