/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.repository;

import ht.mbds.haiti.rase.model.Demographie;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

/**
 *
 * @author MyPC
 */
public interface DemographieRepositoryCostum {
    
   public Demographie getDemographieByGeomIntersectPoint( Point point); 
   
   public Demographie getDemographieByGeomIntersectGeoJsonPoint( GeoJsonPoint point); 
   
   public void test ();
}
