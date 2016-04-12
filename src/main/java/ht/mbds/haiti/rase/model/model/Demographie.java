/*
 * To change this license header, choose License Headers in Project PropertiesDemographie.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.model;

/**
 *
 * @author MyPC
 */


import java.io.Serializable;
import org.springframework.data.mongodb.core.geo.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "geo_section_demographie")
public class Demographie implements Serializable 
{
    @Id
    private String id ;
    
    private PropertiesDemographie properties;

    private String type;

    private Geometry geometry;

    public Demographie() {
    }

    public Demographie(String _id, PropertiesDemographie properties, String type, Geometry geometry) {
        this.id = _id;
        this.properties = properties;
        this.type = type;
        this.geometry = geometry;
    }

   
    public String getId() {
        return id;
    }

    public void setId(String _id) {
        this.id = _id;
    }

    public PropertiesDemographie getProperties ()
    {
        return properties;
    }

    public void setProperties (PropertiesDemographie properties)
    {
        this.properties = properties;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public Geometry getGeometry ()
    {
        return geometry;
    }

    public void setGeometry (Geometry geometry)
    {
        this.geometry = geometry;
    }

    @Override
    public String toString()
    {
        return "Demographie [properties = "+properties+", type = "+type+", geometry = "+geometry.getCoordinates().toString()+"]";
    }
}