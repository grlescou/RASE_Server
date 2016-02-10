/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.Maladie;
import org.springframework.data.repository.Repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.Query;
/**
 *
 * @author MyPC
 */
public interface MaladieRepository extends MongoRepository<Maladie,String> {
    
    
    public Maladie findByNom(String nom);
     
}
