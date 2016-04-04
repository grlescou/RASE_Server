/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.model;

import java.io.Serializable;

/**
 *
 * @author gaetan
 */
public class MultiGeometry  implements Serializable {
   private String type;

    private Double[][][] [] coordinates;

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public Double[][][] [] getCoordinates ()
    {
        return coordinates;
    }

    public void setCoordinates (Double[][][] [] coordinates)
    {
        this.coordinates = coordinates;
    }

    @Override
    public String toString()
    {
        return "MultiGeometry [type = "+type+"]";
    }
    
}
