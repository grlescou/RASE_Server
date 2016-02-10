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
import ht.mbds.haiti.rase.model.repository.AdministrateurRepository;
import ht.mbds.haiti.rase.model.repository.PersonnelSanteRepository;
import ht.mbds.haiti.rase.model.repository.ProfessionRepository;
import ht.mbds.haiti.rase.model.repository.UtilisateurRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MyPC
 */

@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired private UtilisateurRepository utilisateurRepository;
    @Autowired private PersonnelSanteRepository personnelSanteRepository;
    @Autowired private AdministrateurRepository administrateurRepository;
    @Autowired private ProfessionRepository professionRepository ;
    //Utilisateur part 
   
    
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
        return utilisateurRepository.findAll();
    }
    
    @Override
    public List<Utilisateur> findUtilisateurByRole(String role) {
        return utilisateurRepository.findByRole(role);
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
    
    
     @Override
    public PersonnelSante findPersonnelSanteById(String id) {
        return personnelSanteRepository.findOne(id);
    }

    @Override
    public PersonnelSante findPersonnelSanteByMail(String mail) {
        return personnelSanteRepository.findByMail(mail);
    }

    @Override
    public List<PersonnelSante> findPersonnelSanteAll() {
        return personnelSanteRepository.findByRole("PersonnelSante");
    }

    @Override
    public PersonnelSante savePersonnelSante(PersonnelSante user) {
       return  personnelSanteRepository.save(user);
    }

    @Override
    public void deletePersonnelSante(PersonnelSante user) {
       personnelSanteRepository.delete(user);
    }

    @Override
    public void deletePersonnelSante(String id) {
       personnelSanteRepository.delete(id);
    }

    
     @Override
    public Administrateur findAdministrateurById(String id) {
        return administrateurRepository.findOne(id);
    }

    @Override
    public Administrateur findAdministrateurByMail(String mail) {
        return administrateurRepository.findByMail(mail);
    }

    @Override
    public List<Administrateur> findAdministrateurAll() {
        return administrateurRepository.findByRole("Administrateur");
    }

    @Override
    public Administrateur saveAdministrateur(Administrateur user) {
       return  administrateurRepository.save(user);
    }

    @Override
    public void deleteAdministrateur(Administrateur user) {
       administrateurRepository.delete(user);
    }

    @Override
    public void deleteAdministrateur(String id) {
       administrateurRepository.delete(id);
    }
    
    
    // Profession part 
    
    @Override
    public Profession findProfessionById(String id) {
        return professionRepository.findOne(id);
    }

    @Override
    public Profession findProfessionByNom(String nom) {
         return professionRepository.findByNom(nom);
    }

    @Override
    public List<Profession> findProfessionAll() {
     return professionRepository.findAll();
    }

    @Override
    public Profession saveProfession(Profession profession) {
      return professionRepository.save(profession);
    }

    @Override
    public void deleteProfession(Profession profession) {
       professionRepository.delete(profession);
    }

    @Override
    public void deleteProfession(String id) {
        professionRepository.delete(id);
    }
    
}
