/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 *
 * @author gaetan
 */
public class PersonneRepositoryImpl implements PersonneRepositoryCostum {
     @Autowired private MongoOperations mongoOperation ;
     @Autowired private PersonneRepository personneRepo;
    @Override
    public Personne desactiveUtilisateur(String id) {
        Personne UserTrouver = personneRepo.findOne(id);
        if (UserTrouver == null)
        {
            return null;
        }
        else
        {
            UserTrouver.setActif(false);
            mongoOperation.save(UserTrouver);
            return UserTrouver;
        }
    }
}
