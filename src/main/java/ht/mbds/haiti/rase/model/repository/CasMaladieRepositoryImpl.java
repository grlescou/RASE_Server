/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.utils.CasMaladieMR;
import ht.mbds.haiti.rase.utils.DateUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.BasicQuery;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author gaetan
 */
public class CasMaladieRepositoryImpl implements CasMaladieRepositoryCostum {
     @Autowired private MongoOperations mongoOperation ;
    
     
    @Override
    public Map<String,CasMaladieMR> getCasMaladieMR_Departement(Long idMaldie, String dateDebut,String dateFin, String Mention, int note ){
     // Query query = new Query(where("maladie._id").is(idMaldie.toString()));
      //timestamp: { $gte:ISODate("2013-11-19T14:00:00Z"), $lt: ISODate("2013-11-19T20:00:00Z") }
      
      String dDebut = DateUtils.getDateFormater(dateDebut, DateUtils.DB_FORMAT_DATE,DateUtils.DB_FORMAT_ISO_DATETIME);
      String dFin = DateUtils.getDateFormater(dateFin,  DateUtils.DB_FORMAT_DATE,DateUtils.DB_FORMAT_ISO_DATETIME);
      
      
      
     // String queryString = "{ \"maladie._id\" : "+idMaldie.toString()+", \"timestamp\": { $gte:ISODate("+dateDebut+"), $lt: ISODate("+dateFin+") }";
       //String queryString = "{ \"maladie._id\" : "+idMaldie.toString()+", \"timestamp\": { $gte:\""+dDebut.toString()+"\", $lt:\""+dFin.toString()+"\"}";
      
       String queryString = "{ \"maladie._id\" : "+idMaldie.toString()+", \"date\": { $gte:\""+dDebut+"\", $lt: \""+dFin+"\" }";
      
      if ( Mention.equals("")== false || Mention != null){
          queryString += ", \"mention.nom\": \""+ Mention+"\"";
      }
      
      if ( note >0){
          queryString += ", \"note\": "+ note;
      }
      
      queryString += "}";
      
      BasicQuery query = new BasicQuery(queryString);
      
       
      
      
      MapReduceResults<CasMaladieMR> results = mongoOperation.mapReduce(query,"cas_maladie", "classpath:/js/MapCasMaladieDepartement.js", "classpath:/js/ReduceCasMaladie.js", CasMaladieMR.class);
    Map<String,CasMaladieMR> listCasMaladieMRs = new HashMap<String,CasMaladieMR>();
    for (CasMaladieMR valueObject : results) {
        System.out.println(valueObject);
        listCasMaladieMRs.put(valueObject.get_id().toLowerCase().replaceFirst(" ", "-"),valueObject);
    }  
       return listCasMaladieMRs ;
    }
    
    
    
    @Override
    public Map<String,CasMaladieMR> getCasMaladieMR_Commune(Long idMaldie, String dateDebut,String dateFin, String Mention, int note ){
     // Query query = new Query(where("maladie._id").is(idMaldie.toString()));
      //timestamp: { $gte:ISODate("2013-11-19T14:00:00Z"), $lt: ISODate("2013-11-19T20:00:00Z") }
      
      String dDebut = DateUtils.getDateFormater(dateDebut, DateUtils.DB_FORMAT_DATE,DateUtils.DB_FORMAT_ISO_DATETIME);
      String dFin = DateUtils.getDateFormater(dateFin,  DateUtils.DB_FORMAT_DATE,DateUtils.DB_FORMAT_ISO_DATETIME);
      
      
      
     // String queryString = "{ \"maladie._id\" : "+idMaldie.toString()+", \"timestamp\": { $gte:ISODate("+dateDebut+"), $lt: ISODate("+dateFin+") }";
       //String queryString = "{ \"maladie._id\" : "+idMaldie.toString()+", \"timestamp\": { $gte:\""+dDebut.toString()+"\", $lt:\""+dFin.toString()+"\"}";
      
       String queryString = "{ \"maladie._id\" : "+idMaldie.toString()+", \"date\": { $gte:\""+dDebut+"\", $lt: \""+dFin+"\" }";
      
      if ( Mention.equals("")== false || Mention != null){
          queryString += ", \"mention.nom\": \""+ Mention+"\"";
      }
      
      if ( note >0){
          queryString += ", \"note\": "+ note;
      }
      
      queryString += "}";
      
      BasicQuery query = new BasicQuery(queryString);
      
       
      MapReduceResults<CasMaladieMR> results = mongoOperation.mapReduce(query,"cas_maladie", "classpath:/js/MapCasMaladieCommune.js", "classpath:/js/ReduceCasMaladie.js", CasMaladieMR.class);
    Map<String,CasMaladieMR> listCasMaladieMRs = new HashMap<String,CasMaladieMR>();
    for (CasMaladieMR valueObject : results) {
        System.out.println(valueObject);
        listCasMaladieMRs.put(valueObject.get_id().toLowerCase(),valueObject);
    }  
       return listCasMaladieMRs ;
    }
    
    
    
    
    @Override
    public Map<String,CasMaladieMR> getCasMaladieMR_SectionCommunale(Long idMaldie, String dateDebut,String dateFin, String Mention, int note ){
     // Query query = new Query(where("maladie._id").is(idMaldie.toString()));
      //timestamp: { $gte:ISODate("2013-11-19T14:00:00Z"), $lt: ISODate("2013-11-19T20:00:00Z") }
      
      String dDebut = DateUtils.getDateFormater(dateDebut, DateUtils.DB_FORMAT_DATE,DateUtils.DB_FORMAT_ISO_DATETIME);
      String dFin = DateUtils.getDateFormater(dateFin,  DateUtils.DB_FORMAT_DATE,DateUtils.DB_FORMAT_ISO_DATETIME);
      
      
      
     // String queryString = "{ \"maladie._id\" : "+idMaldie.toString()+", \"timestamp\": { $gte:ISODate("+dateDebut+"), $lt: ISODate("+dateFin+") }";
       //String queryString = "{ \"maladie._id\" : "+idMaldie.toString()+", \"timestamp\": { $gte:\""+dDebut.toString()+"\", $lt:\""+dFin.toString()+"\"}";
      
       String queryString = "{ \"maladie._id\" : "+idMaldie.toString()+", \"date\": { $gte:\""+dDebut+"\", $lt: \""+dFin+"\" }";
      
      if ( Mention.equals("")== false || Mention != null){
          queryString += ", \"mention.nom\": \""+ Mention+"\"";
      }
      
      if ( note >0){
          queryString += ", \"note\": "+ note;
      }
      
      queryString += "}";
      
      BasicQuery query = new BasicQuery(queryString);
      
       
      MapReduceResults<CasMaladieMR> results = mongoOperation.mapReduce(query,"cas_maladie", "classpath:/js/MapCasMaladieSectionCommunale.js", "classpath:/js/ReduceCasMaladie.js", CasMaladieMR.class);
    Map<String,CasMaladieMR> listCasMaladieMRs = new HashMap<String,CasMaladieMR>();
    for (CasMaladieMR valueObject : results) {
        System.out.println(valueObject);
        listCasMaladieMRs.put(valueObject.get_id().toLowerCase(),valueObject);
    }  
       return listCasMaladieMRs ;
    }
    
    
    
}
