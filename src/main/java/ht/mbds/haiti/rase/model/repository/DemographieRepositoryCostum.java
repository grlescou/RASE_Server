/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.Demographie;
import ht.mbds.haiti.rase.utils.GeoLocation;
import java.util.List;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

/**
 *
 * @author MyPC
 */
public interface DemographieRepositoryCostum {
    
   public Demographie getDemographieByGeomIntersectPoint( GeoLocation Glocation); 
   
   
   
   public void test ();
   public boolean createUtilisateur();
}
