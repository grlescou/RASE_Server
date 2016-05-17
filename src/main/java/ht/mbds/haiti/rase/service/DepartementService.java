/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Departement;
import ht.mbds.haiti.rase.model.model.utils.ListDepartement;
import java.util.List;

/**
 *
 * @author gaetan
 */
public interface DepartementService {
    
    
    public List<Departement> getDepartement (long idMaladie);
    
    public List<ListDepartement> getListDepartement();
    
}
