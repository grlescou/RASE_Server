/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.Demographie;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author MyPC
 */
public interface DemographieRepository extends MongoRepository<Demographie,Long>, DemographieRepositoryCostum{
  public Demographie findByPropertiesCOMMUNE (String Commune) ;
  
}
