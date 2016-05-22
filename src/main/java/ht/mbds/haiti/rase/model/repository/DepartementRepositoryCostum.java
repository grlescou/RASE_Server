/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.Departement;
import ht.mbds.haiti.rase.model.model.utils.ListDepartement;
import java.util.List;
import javax.json.JsonObject;

/**
 *
 * @author gaetan
 */
public interface DepartementRepositoryCostum {
    
      public List<Departement> getDepartementDemographieCM(Long idMaldie); 
//      public JsonObject getListDepartement(); 
    
}
