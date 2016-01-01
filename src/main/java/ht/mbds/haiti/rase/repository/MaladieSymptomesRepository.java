/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.repository;

import ht.mbds.haiti.rase.model.MaladieSymptomes;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author MyPC
 */
public interface MaladieSymptomesRepository extends MongoRepository<MaladieSymptomes,Long> {
     public List<MaladieSymptomes> findByMaladieId(long Id);
     public List<MaladieSymptomes> findByMaladieNom(String nom);
     public List<MaladieSymptomes> findBySymptomesId(long Id);
     
}
