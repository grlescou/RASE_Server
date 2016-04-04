/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.Commune;
import ht.mbds.haiti.rase.model.model.Departement;
import ht.mbds.haiti.rase.model.model.utils.CasMaladieMR;
import ht.mbds.haiti.rase.model.model.utils.DemographieValue;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 *
 * @author gaetan
 */
public class CommuneRepositoryImpl implements CommuneRepositoryCostum {
    
      @Autowired private MongoOperations mongoOperation ;
   
    @Autowired private CasMaladieRepository casMaladieRepo;
    @Autowired private CommuneRepository communeRepo;
    @Autowired private DemographieRepository demographietRepo;
    
    @Override
    public List<Commune> getCommuneDemographieCM(long idMaladie){
    
      List<Commune> listCommune= communeRepo.findAll();
    
      Map<String,CasMaladieMR> listCasMaladieMRs= casMaladieRepo.getCasMaladieMR_Commune(idMaladie);
    
       Map<String,DemographieValue> listDemographieValueMRs= demographietRepo.getDemographieByCommune();
    
    for (Commune com : listCommune) {
       
        String StrCommune = com.getProperties().getADM3().toLowerCase();
        
        //listCasMaladieMRs.get(StrDepartement);
        //listDemographieValueMRs.get(StrDepartement);
        
        if(listCasMaladieMRs.containsKey(StrCommune)){
           com.getProperties().setCasMaladieValue(listCasMaladieMRs.get(StrCommune).getValue());
        }
        else
        {
           com.getProperties().setCasMaladieValue(null);   
        }
        
        if(listDemographieValueMRs.containsKey(StrCommune))
        {
        com.getProperties().setDemographieValue( listDemographieValueMRs.get(StrCommune));
        }
        else
        {
          com.getProperties().setDemographieValue(null);  
        }
        
    } 
       return listCommune ;
    }
    
    
    
}
