/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;


import ht.mbds.haiti.rase.model.model.MentionResponsabilite;
import ht.mbds.haiti.rase.model.model.Utilisateur;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author gaetan
 */
public interface UtilisateurRepository extends MongoRepository<Utilisateur,String>{
     public Utilisateur findByMail (String mail);
     public List<Utilisateur> findByMentionResponsabiliteId (String id);
      public List<Utilisateur> findByMentionResponsabiliteNom (String nom);
     public List<Utilisateur> findByRolePrivilege (String role);
      public List<Utilisateur> findByRoleId (String id);
     
}
