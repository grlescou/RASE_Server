/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

/**
 *
 * @author gaetan
 */

import ht.mbds.haiti.rase.model.model.Administrateur;
import ht.mbds.haiti.rase.model.model.Utilisateur;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface AdministrateurRepository extends MongoRepository<Administrateur,String>{
     public Administrateur findByMail (String mail);
     public List<Administrateur> findByRolePrivilege (String role);
     public List<Administrateur> findByRoleId (String id);
}
