/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.Profession;
import ht.mbds.haiti.rase.model.User;
import ht.mbds.haiti.rase.repository.ProfessionRepository;
import ht.mbds.haiti.rase.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MyPC
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired private UserRepository userRepository;
    @Autowired private ProfessionRepository professionRepository ;
    //User part 
   
    
    @Override
    public User findUserById(String id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findUserByMail(String mail) {
        return userRepository.findByMail(mail);
    }

    @Override
    public List<User> findUserAll() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
       return  userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
       userRepository.delete(user);
    }

    @Override
    public void deleteUser(String id) {
       userRepository.delete(id);
    }

    // Profession part 
    
    @Override
    public Profession findProfessionById(String id) {
        return professionRepository.findOne(id);
    }

    @Override
    public Profession findProfessionByNom(String nom) {
         return professionRepository.findByNom(nom);
    }

    @Override
    public List<Profession> findProfessionAll() {
     return professionRepository.findAll();
    }

    @Override
    public Profession saveProfession(Profession profession) {
      return professionRepository.save(profession);
    }

    @Override
    public void deleteProfession(Profession profession) {
       professionRepository.delete(profession);
    }

    @Override
    public void deleteProfession(String id) {
        professionRepository.delete(id);
    }
    
}
