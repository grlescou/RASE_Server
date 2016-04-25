/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;


import ht.mbds.haiti.rase.model.model.Utilisateur;
import ht.mbds.haiti.rase.model.model.Personne;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author gaetan
 */
public interface PersonneRepository extends MongoRepository<Personne,String> , PersonneRepositoryCostum{
    
    public Personne findByMail (String mail);
    public List<Personne> findByRole (String role);
    //public List<Utilisateur> findByProfessionId (String id);
    //public List<Utilisateur> findByProfessionNom (String nom);
    
}
