/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Categorie;
import ht.mbds.haiti.rase.model.repository.CategorieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kathleen
 */

@Service
@Transactional
public class CategorieServiceImpl implements CategorieService{
 
    @Autowired private CategorieRepository categorieRepository;
     
    @Override
    public Categorie findCategorieById(String id) {
      return  categorieRepository.findOne(id);
    }

    @Override
    public Categorie findCategorieByNom(String nom) {
       return categorieRepository.findByNom(nom);
    }

    @Override
    public List<Categorie> findCategorieAll() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie saveCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void deleteCategorie(Categorie categorie) {
        categorieRepository.delete(categorie);
    }

    @Override
    public void deleteCategorie(String id) {
       categorieRepository.delete(id);
    }
    
}
