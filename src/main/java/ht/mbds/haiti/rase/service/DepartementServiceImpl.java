/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Departement;
import ht.mbds.haiti.rase.model.model.utils.ListDepartement;
import ht.mbds.haiti.rase.model.repository.DemographieRepository;
import ht.mbds.haiti.rase.model.repository.DepartementRepository;
import java.util.List;
import javax.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gaetan
 */

@Service
@Transactional
public class DepartementServiceImpl implements DepartementService {
    
    @Autowired private DepartementRepository departementRepository;
    
    
    @Override
      public List<Departement> getDepartement (long idMaladie){
          
          return departementRepository.getDepartementDemographieCM(idMaladie);
          
      }

   
      
      
    
}
