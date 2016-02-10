/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.Utilisateur;

/**
 *
 * @author gaetan
 */
public interface UtilisateurRepositoryCostum {
    
    public Utilisateur desactiveUtilisateur(String id);
    
    
}
