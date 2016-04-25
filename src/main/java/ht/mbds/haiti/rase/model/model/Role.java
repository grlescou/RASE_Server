/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author gaetan
 */


@Document(collection = "role")
public class Role {
    @Id 
    private String _id;
    private String privilege;

    public Role() {
    }

    public Role(@JsonProperty("privilege")String privilege) {
        this.privilege = privilege;
    }
    
    
    
    
    
    @JsonIgnore
    public boolean isNew() {
        return _id == null;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    } 

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
    
    
}
