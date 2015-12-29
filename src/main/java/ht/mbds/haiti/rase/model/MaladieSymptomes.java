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

/**
 *
 * @author MyPC
 */
@Document(collection="maladieSymptomes")
public class MaladieSymptomes implements Serializable 
{   
    @Id
    private long _id;
     
    private Maladie maladie;

    private List<Symptome> symptomes;

   

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

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }



    @Override
    public String toString()
    {
        return "Maladie [Maladie = "+maladie+", symptome = "+symptomes.toString()+", _id = "+_id+"]";
    }
}
		