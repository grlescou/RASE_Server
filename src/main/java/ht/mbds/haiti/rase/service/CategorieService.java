/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Categorie;
import java.util.List;

/**
 *
 * @author Kathleen
 */
public interface CategorieService {
     public Categorie findCategorieById(String id);
    
     public Categorie findCategorieByNom(String nom);
     
     public List<Categorie> findCategorieAll();
    
     public Categorie saveCategorie ( Categorie categorie);
     
     public void deleteCategorie (Categorie categorie);
     
     public void deleteCategorie (String id);
     
    
}
