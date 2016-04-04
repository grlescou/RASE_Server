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
public class CasMaladieMR  implements Serializable {
    
    
    private String _id;

    private CasMaladieValue value;

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    public CasMaladieValue getValue ()
    {
        return value;
    }

    public void setValue (CasMaladieValue value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "CasMaladieMR [_id = "+_id+", CasMaladieValue = "+value+"]";
    }
    
}
