/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.model.utils;

import java.io.Serializable;

/**
 *
 * @author gaetan
 */
public class DemographieValue implements Serializable {
    
     private String _id;

    private PopulationValue value;

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    public PopulationValue getPopulationValue ()
    {
        return value;
    }

    public void setPopulationValue (PopulationValue value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "DemographieValue [_id = "+_id+", value = "+value+"]";
    }
    
}
