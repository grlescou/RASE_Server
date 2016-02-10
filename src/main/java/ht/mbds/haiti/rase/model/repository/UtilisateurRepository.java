/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;


import ht.mbds.haiti.rase.model.model.PersonnelSante;
import ht.mbds.haiti.rase.model.model.Utilisateur;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author gaetan
 */
public interface UtilisateurRepository extends MongoRepository<Utilisateur,String> , UtilisateurRepositoryCostum{
    
    public Utilisateur findByMail (String mail);
    public List<Utilisateur> findByRole (String role);
    //public List<Utilisateur> findByProfessionId (String id);
    //public List<Utilisateur> findByProfessionNom (String nom);
    
}
