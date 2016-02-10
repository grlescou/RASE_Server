/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.CasMaladie;
import java.util.List;

/**
 *
 * @author MyPC
 */
public interface CasMaladieService {
    
  // CasMaladie 
     public CasMaladie findCasMaladieById(String id);
    
     public List<CasMaladie> findCasMaladieByMaladieId(String Id);
     public List<CasMaladie> findCasMaladieByMaladieNom(String nom);
//     public List<CasMaladie> findCasMaladieBySymptomesId(long Id);
//     public List<CasMaladie> findCasMaladieBySymptomesNom(String nom);
     
     public List<CasMaladie> findCasMaladieAll();
    
     public CasMaladie saveCasMaladie ( CasMaladie casMaladie);
     
     public void deleteCasMaladie (CasMaladie casMaladie);
     
     public void deleteCasMaladie (String id);  
    
}
