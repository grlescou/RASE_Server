/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.Demographie;
import java.util.List;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

/**
 *
 * @author MyPC
 */
public interface DemographieService {
      public Demographie getDemographieByGeomIntersectPoint( Point point); 
   
      public Demographie getDemographieByGeomIntersectGeoJsonPoint( GeoJsonPoint point); 
      
      public List<Demographie> findDemographieAll() ;
      public void test ();
}
