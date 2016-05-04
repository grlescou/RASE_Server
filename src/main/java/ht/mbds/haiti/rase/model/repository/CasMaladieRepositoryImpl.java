/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.utils.CasMaladieMR;
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
public class CasMaladieRepositoryImpl implements CasMaladieRepositoryCostum {
     @Autowired private MongoOperations mongoOperation ;
    
      
    @Override
    public Map<String,CasMaladieMR> getCasMaladieMR_Departement(Long idMaldie){
      Query query = new Query(where("maladie._id").is(idMaldie.toString()));
      MapReduceResults<CasMaladieMR> results = mongoOperation.mapReduce(query,"cas_maladie", "classpath:/js/MapCasMaladieDepartement.js", "classpath:/js/ReduceCasMaladie.js", CasMaladieMR.class);
    Map<String,CasMaladieMR> listCasMaladieMRs = new HashMap<String,CasMaladieMR>();
    for (CasMaladieMR valueObject : results) {
        System.out.println(valueObject);
        listCasMaladieMRs.put(valueObject.get_id().toLowerCase().replaceFirst(" ", "-"),valueObject);
    }  
       return listCasMaladieMRs ;
    }
    
    
    
    @Override
    public Map<String,CasMaladieMR> getCasMaladieMR_Commune(Long idMaldie){
      Query query = new Query(where("maladie._id").is(idMaldie.toString()));
      MapReduceResults<CasMaladieMR> results = mongoOperation.mapReduce(query,"cas_maladie", "classpath:/js/MapCasMaladieCommune.js", "classpath:/js/ReduceCasMaladie.js", CasMaladieMR.class);
    Map<String,CasMaladieMR> listCasMaladieMRs = new HashMap<String,CasMaladieMR>();
    for (CasMaladieMR valueObject : results) {
        System.out.println(valueObject);
        listCasMaladieMRs.put(valueObject.get_id().toLowerCase(),valueObject);
    }  
       return listCasMaladieMRs ;
    }
    
    
    
    
       @Override
    public Map<String,CasMaladieMR> getCasMaladieMR_SectionCommunale(Long idMaldie){
      Query query = new Query(where("maladie._id").is(idMaldie.toString()));
      MapReduceResults<CasMaladieMR> results = mongoOperation.mapReduce(query,"cas_maladie", "classpath:/js/MapCasMaladieSectionCommunale.js", "classpath:/js/ReduceCasMaladie.js", CasMaladieMR.class);
    Map<String,CasMaladieMR> listCasMaladieMRs = new HashMap<String,CasMaladieMR>();
    for (CasMaladieMR valueObject : results) {
        System.out.println(valueObject);
        listCasMaladieMRs.put(valueObject.get_id().toLowerCase(),valueObject);
    }  
       return listCasMaladieMRs ;
    }
    
    
    
}
