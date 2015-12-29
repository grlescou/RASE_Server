/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.Maladie;
import java.util.List;

/**
 *
 * @author MyPC
 */
public interface MaladieService {
    
    // maladie 
    
    public Maladie findMaladieById(long id);
    
     public Maladie findMaladieByNom(String nom);
     
     public List<Maladie> findMaladieAll();
    
}
