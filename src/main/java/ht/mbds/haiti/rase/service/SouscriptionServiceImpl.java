/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Souscription;
import ht.mbds.haiti.rase.model.repository.SouscriptionRepository;
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
public class SouscriptionServiceImpl implements SouscriptionService {
     
     @Autowired private SouscriptionRepository souscriptionRepository;
    
    @Override
    public Souscription findSouscriptionById(String id) {
      return souscriptionRepository.findOne(id);
    }

    @Override
    public Souscription findSouscriptionByNom(String email) {
        return souscriptionRepository.findByEmail(email);
    }

    @Override
    public List<Souscription> findSouscriptionAll() {
       return souscriptionRepository.findAll();
    }

    @Override
    public Souscription saveSouscription(Souscription souscription) {
       return souscriptionRepository.save(souscription);
    }

    @Override
    public void deleteSouscription(Souscription souscription) {
       souscriptionRepository.delete(souscription);
    }

    @Override
    public void deleteSouscription(String id) {
       souscriptionRepository.delete(id);
    }
    
}
