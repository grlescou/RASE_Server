/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Justificatif;
import java.util.List;

/**
 *
 * @author gaetan
 */
public interface JustificatifService {
     // justificatif 
    
     public Justificatif findJustificatifById(String id);
    
     public List<Justificatif>  findJustificatifByUserId(String idUser);
     
     public List<Justificatif> findJustificatifAll();
    
     public Justificatif saveJustificatif ( Justificatif justificatif);
     
     public void deleteJustificatif (Justificatif justificatif);
     
     public void deleteJustificatif (String id);
    
}
