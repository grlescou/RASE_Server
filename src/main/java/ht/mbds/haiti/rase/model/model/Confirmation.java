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
@Document(collection = "confirmation")
public class Confirmation implements Serializable {
    
      @Id
    private String id;
    private Utilisateur confirmerPar;
    
    @DBRef
    private HistoriqueDetection alerte;
    private String dateConfirmation;
    
     @JsonCreator
    public Confirmation(@JsonProperty("confirmerPar") Utilisateur confirmerPar, @JsonProperty("alerte") HistoriqueDetection alerte,@JsonProperty("dateConfirmation") String dateConfirmation) {

        this.confirmerPar = confirmerPar;
        this.alerte = alerte;
        this.dateConfirmation = dateConfirmation;
    }

    
    
    public Confirmation() {
    }

     @JsonIgnore
    public boolean isNew() {
        return id == null;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Utilisateur getConfirmerPar() {
        return confirmerPar;
    }

    public void setConfirmerPar(Utilisateur confirmerPar) {
        this.confirmerPar = confirmerPar;
    }

    public HistoriqueDetection getAlerte() {
        return alerte;
    }

    public void setAlerte(HistoriqueDetection alerte) {
        this.alerte = alerte;
    }

    public String getDateConfirmation() {
        return dateConfirmation;
    }

    public void setDateConfirmation(String dateConfirmation) {
        this.dateConfirmation = dateConfirmation;
    }
    
    
    
}
