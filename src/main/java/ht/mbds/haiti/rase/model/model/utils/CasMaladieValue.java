/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.model.utils;

import ht.mbds.haiti.rase.model.model.Maladie;
import java.io.Serializable;

/**
 *
 * @author gaetan
 */
public class CasMaladieValue implements Serializable {
  
    private String _id;
    
    private Maladie maladie;
    
    private long count;
    
    private long hommes;
    
    private long femmes;
    
    private long moins_5an;
    
    private long mixe;

    public long getCount ()
    {
        return count;
    }

    public void setCount (long count)
    {
        this.count = count;
    }

    public long getHommes() {
        return hommes;
    }

    public void setHommes(long hommes) {
        this.hommes = hommes;
    }

    public long getFemmes() {
        return femmes;
    }

    public void setFemmes(long femmes) {
        this.femmes = femmes;
    }

    public long getMoins_5an() {
        return moins_5an;
    }

    public void setMoins_5an(long moins_5an) {
        this.moins_5an = moins_5an;
    }

    public long getMixe() {
        return mixe;
    }

    public void setMixe(long mixe) {
        this.mixe = mixe;
    }

    
    
    
    public Maladie getMaladie ()
    {
        return maladie;
    }

    public void setMaladie (Maladie maladie)
    {
        this.maladie = maladie;
    }

       public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "CasMaladieValue{" + "_id=" + _id + ", maladie=" + maladie + ", count=" + count + ", hommes=" + hommes + ", femmes=" + femmes + ", moins_5an=" + moins_5an + ", mixe=" + mixe + '}';
    }

   
}
