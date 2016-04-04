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
    
    

    public long getCount ()
    {
        return count;
    }

    public void setCount (long count)
    {
        this.count = count;
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
    public String toString()
    {
        return "CasMaladieValue [count = "+count+", maladie = "+maladie+", _id = "+_id+"]";
    }
}
