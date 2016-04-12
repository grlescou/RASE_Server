/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Parametre;
import ht.mbds.haiti.rase.model.repository.ParametreRepository;
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
public class ParametreServiceImpl implements ParametreService {
    
    
     @Autowired private ParametreRepository parametreRepository;
    
    @Override
    public Parametre findParametreById(String id) {
      return parametreRepository.findOne(id);
    }

    @Override
    public Parametre findParametreByNom(String nom) {
        return parametreRepository.findByNom(nom);
    }

    @Override
    public List<Parametre> findParametreAll() {
       return parametreRepository.findAll();
    }

    @Override
    public Parametre saveParametre(Parametre parametre) {
       return parametreRepository.save(parametre);
    }

    @Override
    public void deleteParametre(Parametre parametre) {
       parametreRepository.delete(parametre);
    }

    @Override
    public void deleteParametre(String id) {
       parametreRepository.delete(id);
    }
    
}
