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
public class ListDepartement implements Serializable{
    
   private  String DEPARTEMEN;

    public ListDepartement(String DEPARTEMEN) {
        this.DEPARTEMEN = DEPARTEMEN;
    }

    public String getDEPARTEMEN() {
        return DEPARTEMEN;
    }

    public void setDEPARTEMEN(String departemen) {
        this.DEPARTEMEN = departemen;
    }
   
   
   
    
}
