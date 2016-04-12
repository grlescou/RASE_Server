/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.Departement;
import ht.mbds.haiti.rase.model.model.Maladie;
import ht.mbds.haiti.rase.model.model.utils.CasMaladieMR;
import ht.mbds.haiti.rase.model.model.utils.CasMaladieValue;
import ht.mbds.haiti.rase.model.model.utils.DemographieValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author gaetan
 */
public class DepartementRepositoryImpl implements DepartementRepositoryCostum{
     @Autowired private MongoOperations mongoOperation ;
   
    @Autowired private CasMaladieRepository casMaladieRepo;
    @Autowired private DepartementRepository departementRepo;
    @Autowired private DemographieRepository demographietRepo;
    
     @Autowired private MaladieRepository maladieRepo;
    
    @Override
    public List<Departement> getDepartementDemographieCM(Long idMaldie){
    
      List<Departement> listDepartement= departementRepo.findAll();
      
      Maladie maladieRecherche = maladieRepo.findOne(idMaldie.toString());
    
      Map<String,CasMaladieMR> listCasMaladieMRs= casMaladieRepo.getCasMaladieMR_Departement(idMaldie);
    
       Map<String,DemographieValue> listDemographieValueMRs= demographietRepo.getDemographieByDepartement();
    
    for (Departement dep : listDepartement) {
       
        String StrDepartement = dep.getProperties().getADM1().toLowerCase();
        
        //listCasMaladieMRs.get(StrDepartement);
        //listDemographieValueMRs.get(StrDepartement);
        
        if(listCasMaladieMRs.containsKey(StrDepartement)){
        dep.getProperties().setCasMaladieValue(listCasMaladieMRs.get(StrDepartement).getValue());
        }
        else
        {
            CasMaladieValue cmv = new CasMaladieValue();
            cmv.setCount(0);
            cmv.setMaladie(maladieRecherche);
            cmv.set_id(StrDepartement);
           dep.getProperties().setCasMaladieValue(cmv);   
        }
        
        if(listDemographieValueMRs.containsKey(StrDepartement))
        {
        dep.getProperties().setDemographieValue( listDemographieValueMRs.get(StrDepartement));
        }
        else
        {
          dep.getProperties().setDemographieValue( null);  
        }
        
    } 
       return listDepartement ;
    }
    
    
    
}
