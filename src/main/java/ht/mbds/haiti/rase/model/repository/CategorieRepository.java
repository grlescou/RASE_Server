/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.Categorie;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Kathleen
 */
public interface CategorieRepository extends MongoRepository<Categorie,String>  {
    
    public Categorie findByNom(String nom);
    
}
