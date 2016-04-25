/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.GroupeIndividu;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author gaetan
 */
public interface GroupeIndividuRepository extends MongoRepository<GroupeIndividu,String> {
        public GroupeIndividu findByNomGroupe(String nomGroupe) ;
}
