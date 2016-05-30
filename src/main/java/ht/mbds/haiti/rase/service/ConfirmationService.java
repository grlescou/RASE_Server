/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Confirmation;
import java.util.List;

/**
 *
 * @author gaetan
 */
public interface ConfirmationService {
    
     // confirmation 
    
    public Confirmation findConfirmationById(String id);
    
//     public Confirmation findConfirmationByNom(String nom);
     
     public List<Confirmation> findConfirmationAll();
    
     public Confirmation saveConfirmation ( Confirmation confirmation);
     
     public void deleteConfirmation (Confirmation confirmation);
     
     public void deleteConfirmation (String id);
    
}
