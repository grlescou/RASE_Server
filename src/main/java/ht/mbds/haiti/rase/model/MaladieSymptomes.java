/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author MyPC
 */
@Document(collection="maladieSymptomes")
public class MaladieSymptomes implements Serializable 
{   
    @Id
    private String id;
     
    private Maladie maladie;

    private List<Symptome> symptomes;

    @JsonCreator
    public MaladieSymptomes(@JsonProperty("maladie") Maladie maladie, @JsonProperty("symptomes")  List<Symptome> symptomes) {
        this.maladie = maladie;
        this.symptomes = symptomes;
    }

    @JsonIgnore
    public boolean isNew() {
        return id == null;
    }
    

    public Maladie getMaladie ()
    {
        return maladie;
    }

    public void setMaladie (Maladie Maladie)
    {
        this.maladie = Maladie;
    }

    public List<Symptome> getSymptomes ()
    {
        return symptomes;
    }

    public void setSymptomes (List<Symptome> symptomes)
    {
        this.symptomes = symptomes;
    }

    public String getId() {
        return id;
    }

    public void setId(String _id) {
        this.id = _id;
    }



    @Override
    public String toString()
    {
        return "Maladie [Maladie = "+maladie+", symptome = "+symptomes.toString()+", _id = "+id+"]";
    }
}
		