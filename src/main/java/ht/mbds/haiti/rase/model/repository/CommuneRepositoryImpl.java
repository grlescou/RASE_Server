/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.Commune;
import ht.mbds.haiti.rase.model.model.Departement;
import ht.mbds.haiti.rase.model.model.Maladie;
import ht.mbds.haiti.rase.model.model.utils.CasMaladieMR;
import ht.mbds.haiti.rase.model.model.utils.CasMaladieValue;
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
    
    @Autowired private MaladieRepository maladieRepo;
    
    @Override
    public List<Commune> getCommuneDemographieCM(Long idMaladie, String dateDebut,String dateFin, String Mention, int note ){
    
      List<Commune> listCommune= communeRepo.findAll();
       Maladie maladieRecherche = maladieRepo.findOne(idMaladie.toString());
    
      Map<String,CasMaladieMR> listCasMaladieMRs= casMaladieRepo.getCasMaladieMR_Commune(idMaladie,dateDebut,dateFin,Mention,note);
    
       Map<String,DemographieValue> listDemographieValueMRs= demographietRepo.getDemographieByCommune();
    
    for (Commune com : listCommune) {
       
        String StrCommune = com.getProperties().getADM3().toLowerCase();
        
        //listCasMaladieMRs.get(StrDepartement);
        //listDemographieValueMRs.get(StrDepartement);
        
        if(listCasMaladieMRs.containsKey(StrCommune)){
           com.getProperties().setCasMaladieValue(listCasMaladieMRs.get(StrCommune).getValue());
           System.out.println("===x===="+listCasMaladieMRs.get(StrCommune).getValue());
        }
        else
        {
            CasMaladieValue cmv = new CasMaladieValue();
            cmv.setCount(0);
            cmv.setFemmes(0);
            cmv.setHommes(0);
            cmv.setMixe(0);
            cmv.setMoins_5an(0);
            maladieRecherche.setDescription(null);
            cmv.setMaladie(maladieRecherche);
            cmv.set_id(StrCommune);
            com.getProperties().setCasMaladieValue(cmv);   
            System.out.println("======="+cmv); 
            
          
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
