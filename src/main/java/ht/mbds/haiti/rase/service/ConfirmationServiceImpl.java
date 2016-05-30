/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Confirmation;
import ht.mbds.haiti.rase.model.repository.ConfirmationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gaetan
 */

@Service
@Transactional
public class ConfirmationServiceImpl implements ConfirmationService {

    @Autowired private ConfirmationRepository confirmationRepository;
    
    @Override
    public Confirmation findConfirmationById(String id) {
      return confirmationRepository.findOne(id);
    }

//    @Override
//    public Confirmation findConfirmationByNom(String nom) {
//        return confirmationRepository.(nom);
//    }

    @Override
    public List<Confirmation> findConfirmationAll() {
       return confirmationRepository.findAll();
    }

    @Override
    public Confirmation saveConfirmation(Confirmation confirmation) {
       return confirmationRepository.save(confirmation);
    }

    @Override
    public void deleteConfirmation(Confirmation confirmation) {
       confirmationRepository.delete(confirmation);
    }

    @Override
    public void deleteConfirmation(String id) {
       confirmationRepository.delete(id);
    }
    
}
