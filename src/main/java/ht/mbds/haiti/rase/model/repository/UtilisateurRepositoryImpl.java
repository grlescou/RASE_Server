/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 *
 * @author gaetan
 */
public class UtilisateurRepositoryImpl implements UtilisateurRepositoryCostum {
     @Autowired private MongoOperations mongoOperation ;
     @Autowired private UtilisateurRepository utilisateurRepo;
    @Override
    public Utilisateur desactiveUtilisateur(String id) {
        Utilisateur UserTrouver = utilisateurRepo.findOne(id);
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
