/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Administrateur;
import ht.mbds.haiti.rase.model.model.Utilisateur;
import ht.mbds.haiti.rase.model.model.MentionResponsabilite;
import ht.mbds.haiti.rase.model.model.Personne;
import java.util.List;

/**
 *
 * @author gaetan
 */
public interface UtilisateurService {
    
    // Personne 
     public Personne findPersonneById(String id);
    
     public Personne findPersonneByMail(String mail);
     
     public List<Personne> findPersonneAll();
     
    public List<Personne> findPersonneByRole(String role);
    
     public Personne savePersonne ( Personne user);
     
     public void deletePersonne (Personne user);
     
     public void deletePersonne (String id);
    
  
     
     
     // Utilisateur 
     public Utilisateur findUtilisateurById(String id);
    
     public Utilisateur findUtilisateurByMail(String mail);
     
     public List<Utilisateur> findUtilisateurAll();
    
     public Utilisateur saveUtilisateur ( Utilisateur personel);
     
     public void deleteUtilisateur (Utilisateur personnel);
     
     public void deleteUtilisateur (String id);
     
     
    
}
