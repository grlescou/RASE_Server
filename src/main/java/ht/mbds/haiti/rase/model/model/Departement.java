/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.model;

/**
 *
 * @author gaetan
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import org.springframework.data.mongodb.core.geo.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "geo_departement")
public class Departement  implements Serializable 
{
    @Id 
    private String _id;
    
    private PropertiesDepartement properties;

    private String type;

    private MultiGeometry geometry;

    
    public Departement() {
    }

    
    public Departement(String _id, PropertiesDepartement properties, String type, MultiGeometry geometry) {
        this._id = _id;
        this.properties = properties;
        this.type = type;
        this.geometry = geometry;
    }
    
    
    
    
    @JsonIgnore
    public boolean isNew() {
        return _id == null;
    }

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    public PropertiesDepartement getProperties ()
    {
        return properties;
    }

    public void setProperties (PropertiesDepartement properties)
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

    public MultiGeometry getGeometry ()
    {
        return geometry;
    }

    public void setGeometry (MultiGeometry geometry)
    {
        this.geometry = geometry;
    }

    @Override
    public String toString()
    {
        return "Departement [_id = "+_id+", properties = "+properties+", type = "+type+", geometry = "+geometry+"]";
    }    
    
    
    
    
}
