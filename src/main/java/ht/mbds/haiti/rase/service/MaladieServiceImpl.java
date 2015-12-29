/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

/**
 *
 * @author MyPC
 */

import ht.mbds.haiti.rase.model.Maladie;
import ht.mbds.haiti.rase.repository.MaladieRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MaladieServiceImpl implements MaladieService {

    @Autowired private MaladieRepository maladieRepositry;
    
    @Override
    public Maladie findMaladieById(long id) {
      return maladieRepositry.findOne(id);
    }

    @Override
    public Maladie findMaladieByNom(String nom) {
        return maladieRepositry.findByNom(nom);
    }

    @Override
    public List<Maladie> findMaladieAll() {
       return maladieRepositry.findAll();
    }
    
}
