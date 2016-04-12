/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Souscription;
import java.util.List;

/**
 *
 * @author gaetan
 */
public interface SouscriptionService {
    
     public Souscription findSouscriptionById(String id);
    
     public Souscription findSouscriptionByNom(String nom);
     
     public List<Souscription> findSouscriptionAll();
    
     public Souscription saveSouscription ( Souscription souscription);
     
     public void deleteSouscription (Souscription souscription);
     
     public void deleteSouscription (String id);
    
    
}
