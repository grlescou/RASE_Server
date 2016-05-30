/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.Justificatif;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author gaetan
 */
public interface JustificatifRepository extends MongoRepository<Justificatif,String> {
    public List<Justificatif>  findByUserId(String id);
    
}
