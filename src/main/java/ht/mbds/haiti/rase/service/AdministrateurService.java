/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Administrateur;
import java.util.List;

/**
 *
 * @author gaetan
 */
public interface AdministrateurService {
       // Administrateur 
     public Administrateur findAdministrateurById(String id);
    
     public Administrateur findAdministrateurByMail(String mail);
     
     public List<Administrateur> findAdministrateurAll();
    
     public Administrateur saveAdministrateur ( Administrateur admin);
     
     public void deleteAdministrateur (Administrateur admin);
     
     public void deleteAdministrateur (String id);
}
