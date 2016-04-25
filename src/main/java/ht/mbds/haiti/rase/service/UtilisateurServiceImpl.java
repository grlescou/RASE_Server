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
import ht.mbds.haiti.rase.model.repository.AdministrateurRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ht.mbds.haiti.rase.model.repository.PersonneRepository;
import ht.mbds.haiti.rase.model.repository.MentionResponsabiliteRepository;
import ht.mbds.haiti.rase.model.repository.UtilisateurRepository;

/**
 *
 * @author gaetan
 */

@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired private PersonneRepository personneRepository;
    @Autowired private UtilisateurRepository utilisateurRepository;
    
   
    //Utilisateur part 
   
    
    @Override
    public Personne findPersonneById(String id) {
        return personneRepository.findOne(id);
    }

    @Override
    public Personne findPersonneByMail(String mail) {
        return personneRepository.findByMail(mail);
    }

    @Override
    public List<Personne> findPersonneAll() {
        return personneRepository.findAll();
    }
    
    @Override
    public List<Personne> findPersonneByRole(String role) {
        return personneRepository.findByRole(role);
    }

    @Override
    public Personne savePersonne(Personne user) {
       return  personneRepository.save(user);
    }

    @Override
    public void deletePersonne(Personne user) {
       personneRepository.delete(user);
    }
     @Override
    public void deletePersonne(String id) {
        personneRepository.delete(id);
    }
    

   
    
     @Override
    public Utilisateur findUtilisateurById(String id) {
        return utilisateurRepository.findOne(id);
    }

    @Override
    public Utilisateur findUtilisateurByMail(String mail) {
        return utilisateurRepository.findByMail(mail);
    }

    @Override
    public List<Utilisateur> findUtilisateurAll() {
        return utilisateurRepository.findByRolePrivilege("Utilisateur");
    }

    @Override
    public Utilisateur saveUtilisateur(Utilisateur user) {
       return  utilisateurRepository.save(user);
    }

    @Override
    public void deleteUtilisateur(Utilisateur user) {
       utilisateurRepository.delete(user);
    }

    @Override
    public void deleteUtilisateur(String id) {
       utilisateurRepository.delete(id);
    }

    
   
    
    
   
    
}
