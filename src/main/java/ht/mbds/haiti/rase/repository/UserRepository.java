/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.repository;

import ht.mbds.haiti.rase.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author MyPC
 */
public interface UserRepository extends MongoRepository<User,String>{
   // public User findById(String id);
    public User findByMail (String mail);
    public User findByProfessionId (String id);
    public User findByProfessionNom (String nom);
    
    
}
