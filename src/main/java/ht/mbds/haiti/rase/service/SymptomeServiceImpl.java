/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Symptome;
import ht.mbds.haiti.rase.model.repository.SymptomeRepository;
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
public class SymptomeServiceImpl implements SymptomeService {

    @Autowired private SymptomeRepository SymptomeRepository;
    
    @Override
    public Symptome findSymptomeById(String id) {
       return SymptomeRepository.findOne(id);
    }

    @Override
    public Symptome findSymptomeByNom(String nom) {
        return SymptomeRepository.findByNom(nom);
    }

    @Override
    public List<Symptome> findSymptomeAll() {
       return SymptomeRepository.findAll();
    }

    @Override
    public Symptome saveSymptome(Symptome symptome) {
       return SymptomeRepository.save(symptome);
    }

    @Override
    public void deleteSymptome(Symptome symptome) {
       SymptomeRepository.delete(symptome);
    }

    @Override
    public void deleteSymptome(String id) {
        SymptomeRepository.delete(id);
    }
    
}
