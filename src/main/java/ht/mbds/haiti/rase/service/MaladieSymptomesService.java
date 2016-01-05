/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.MaladieSymptomes;
import java.util.List;

/**
 *
 * @author MyPC
 */
public interface MaladieSymptomesService {
     public MaladieSymptomes findMaladieSymptomesById(String id);
    
     public List<MaladieSymptomes> findMaladieSymptomesByMaladieId(String Id);
     public List<MaladieSymptomes> findMaladieSymptomesByMaladieNom(String nom);
     public List<MaladieSymptomes> findMaladieSymptomesBySymptomesId(String Id);
   
     
     public List<MaladieSymptomes> findMaladieSymptomesAll();
    
     public MaladieSymptomes saveMaladieSymptomes ( MaladieSymptomes maladieSymptomes);
     
     public void deleteMaladieSymptomes (MaladieSymptomes maladieSymptomes);
     
     public void deleteMaladieSymptomes (String id);
}
