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
@Document(collection = "justificatif")
public class Justificatif implements Serializable {
    
    @Id
    private String id;
    private String path;
    private String date;
    @DBRef
    private Utilisateur user;
    private String format;

    public Justificatif() {
    }
    
    @JsonCreator
    public Justificatif(@JsonProperty("path") String path,@JsonProperty("date") String date,@JsonProperty("user") Utilisateur user,@JsonProperty("format") String format) {

        this.date = date;
        this.user = user;
        this.format = format;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
    
    
    
    
    
}
