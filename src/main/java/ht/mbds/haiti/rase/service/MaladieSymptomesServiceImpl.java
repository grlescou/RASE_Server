/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.MaladieSymptomes;
import ht.mbds.haiti.rase.repository.MaladieSymptomesRepository;
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
public class MaladieSymptomesServiceImpl implements MaladieSymptomesService{

    @Autowired private MaladieSymptomesRepository maladieSymptomesRepository ;
    
    @Override
    public MaladieSymptomes findMaladieSymptomesById(long id) {
       return maladieSymptomesRepository.findOne(id);
    }

    @Override
    public List<MaladieSymptomes> findMaladieSymptomesByMaladieId(long Id) {
        return maladieSymptomesRepository.findByMaladieId(Id);
    }

    @Override
    public List<MaladieSymptomes> findMaladieSymptomesByMaladieNom(String nom) {
         return maladieSymptomesRepository.findByMaladieNom(nom);
    }

    @Override
    public List<MaladieSymptomes> findMaladieSymptomesBySymptomesId(long Id) {
        return maladieSymptomesRepository.findBySymptomesId(Id);
    }

    @Override
    public List<MaladieSymptomes> findMaladieSymptomesAll() {
         return maladieSymptomesRepository.findAll();
    }

    @Override
    public MaladieSymptomes saveMaladieSymptomes(MaladieSymptomes maladieSymptomes) {
        return maladieSymptomesRepository.save(maladieSymptomes);
    }

    @Override
    public void deleteMaladieSymptomes(MaladieSymptomes maladieSymptomes) {
       maladieSymptomesRepository.delete(maladieSymptomes);
    }

    @Override
    public void deleteMaladieSymptomes(long id) {
        maladieSymptomesRepository.delete(id);
    }
    
}
