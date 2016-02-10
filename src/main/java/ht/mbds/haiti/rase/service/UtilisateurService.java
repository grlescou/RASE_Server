/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Administrateur;
import ht.mbds.haiti.rase.model.model.PersonnelSante;
import ht.mbds.haiti.rase.model.model.Profession;
import ht.mbds.haiti.rase.model.model.Utilisateur;
import java.util.List;

/**
 *
 * @author MyPC
 */
public interface UtilisateurService {
    
    // Utilisateur 
     public Utilisateur findUtilisateurById(String id);
    
     public Utilisateur findUtilisateurByMail(String mail);
     
     public List<Utilisateur> findUtilisateurAll();
     
    public List<Utilisateur> findUtilisateurByRole(String role);
    
     public Utilisateur saveUtilisateur ( Utilisateur user);
     
     public void deleteUtilisateur (Utilisateur user);
     
     public void deleteUtilisateur (String id);
    
     // Administrateur 
     public Administrateur findAdministrateurById(String id);
    
     public Administrateur findAdministrateurByMail(String mail);
     
     public List<Administrateur> findAdministrateurAll();
    
     public Administrateur saveAdministrateur ( Administrateur admin);
     
     public void deleteAdministrateur (Administrateur admin);
     
     public void deleteAdministrateur (String id);
     
     
     // PersonnelSante 
     public PersonnelSante findPersonnelSanteById(String id);
    
     public PersonnelSante findPersonnelSanteByMail(String mail);
     
     public List<PersonnelSante> findPersonnelSanteAll();
    
     public PersonnelSante savePersonnelSante ( PersonnelSante personel);
     
     public void deletePersonnelSante (PersonnelSante personnel);
     
     public void deletePersonnelSante (String id);
     
     
    //Profession
    public Profession findProfessionById(String id);
    
     public Profession findProfessionByNom(String nom);
     
     public List<Profession> findProfessionAll();
    
     public Profession saveProfession ( Profession profession);
     
     public void deleteProfession (Profession profession);
     
     public void deleteProfession (String id);
}
