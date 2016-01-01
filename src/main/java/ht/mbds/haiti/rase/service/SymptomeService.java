/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.Symptome;
import java.util.List;

/**
 *
 * @author MyPC
 */
public interface SymptomeService {
      // symptome 
    
    public Symptome findSymptomeById(String id);
    
     public Symptome findSymptomeByNom(String nom);
     
     public List<Symptome> findSymptomeAll();
    
     public Symptome saveSymptome ( Symptome symptome);
     
     public void deleteSymptome (Symptome symptome);
     
     public void deleteSymptome (String id);
}
