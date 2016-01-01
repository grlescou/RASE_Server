/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.Profession;
import ht.mbds.haiti.rase.model.User;
import java.util.List;

/**
 *
 * @author MyPC
 */
public interface UserService {
    
    // User 
     public User findUserById(String id);
    
     public User findUserByMail(String mail);
     
     public List<User> findUserAll();
    
     public User saveUser ( User user);
     
     public void deleteUser (User user);
     
     public void deleteUser (String id);
    
    //Profession
    public Profession findProfessionById(String id);
    
     public Profession findProfessionByNom(String nom);
     
     public List<Profession> findProfessionAll();
    
     public Profession saveProfession ( Profession profession);
     
     public void deleteProfession (Profession profession);
     
     public void deleteProfession (String id);
}
