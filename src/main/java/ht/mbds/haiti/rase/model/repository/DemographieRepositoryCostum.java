/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.Demographie;
import ht.mbds.haiti.rase.model.model.Departement;
import ht.mbds.haiti.rase.model.model.utils.CasMaladieMR;
import ht.mbds.haiti.rase.model.model.utils.DemographieValue;
import ht.mbds.haiti.rase.utils.GeoLocation;
import ht.mbds.haiti.rase.utils.SimpleMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;


 import javax.json.JsonObject;

/**
 *
 * @author gaetan
 */
public interface DemographieRepositoryCostum {
    
   public Demographie getDemographieByGeomIntersectPoint( GeoLocation Glocation); 
   
   
   
   public void test ();
   public boolean createUtilisateur();
   public SimpleMessage creerCategorie ();
   
   
   //  Map/Reduce demographie 
   
   //par Departement 
   public Map<String,DemographieValue> getDemographieByDepartement(); 
   // par commune
    public Map<String,DemographieValue> getDemographieByCommune();
    
     public List<Demographie> getSectionCommunaleDemographieCM(Long idMaladie);
     
     public  HashMap<String,HashMap<String,List<String>>>  getDepartementCommuneSectionList();
   
}
