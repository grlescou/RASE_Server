/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model;

/**
 *
 * @author MyPC
 */
public class Geometry {
   private String type;

    private Double[][][] coordinates;

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public Double[][][] getCoordinates ()
    {
        return coordinates;
    }

    public void setCoordinates (Double[][][] coordinates)
    {
        this.coordinates = coordinates;
    }

    @Override
    public String toString()
    {
        return "Geometry [type = "+type+", coordinates = "+coordinates.toString()+"]";
    }
    
}
