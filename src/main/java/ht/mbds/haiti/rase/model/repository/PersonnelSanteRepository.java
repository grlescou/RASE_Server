/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;


import ht.mbds.haiti.rase.model.model.PersonnelSante;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author gaetan
 */
public interface PersonnelSanteRepository extends MongoRepository<PersonnelSante,String>{
     public PersonnelSante findByMail (String mail);
     public List<PersonnelSante> findByProfessionId (String id);
     public List<PersonnelSante> findByRole (String role);
     public List<PersonnelSante> findByProfessionNom (String nom);
}
