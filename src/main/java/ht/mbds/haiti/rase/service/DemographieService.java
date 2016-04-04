/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Demographie;
import ht.mbds.haiti.rase.model.model.utils.CasMaladieMR;
import ht.mbds.haiti.rase.utils.GeoLocation;
import ht.mbds.haiti.rase.utils.Message;
import ht.mbds.haiti.rase.utils.SimpleMessage;
import java.util.List;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

/**
 *
 * @author MyPC
 */
public interface DemographieService {
      public Demographie getDemographieByGeomIntersectPoint( GeoLocation Glocation); 
   
      public List<Demographie> findDemographieAll() ;
      public void test ();
      public SimpleMessage createUtilisateur();
      public SimpleMessage createCategorie();
      
     // public List<CasMaladieMR> getCasMaladieMR(long idMaldie);
}
