/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Parametre;
import java.util.List;

/**
 *
 * @author gaetan
 */
public interface ParametreService  {
    
    
     public Parametre findParametreById(String id);
    
     public Parametre findParametreByNom(String nom);
     
     public List<Parametre> findParametreAll();
    
     public Parametre saveParametre ( Parametre parametre);
     
     public void deleteParametre (Parametre parametre);
     
     public void deleteParametre (String id);
}
