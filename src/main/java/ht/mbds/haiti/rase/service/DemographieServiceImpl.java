/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.Demographie;
import ht.mbds.haiti.rase.repository.DemographieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MyPC
 */
@Service
@Transactional
public class DemographieServiceImpl implements DemographieService {

    @Autowired private DemographieRepository demographieRepository;
    
    @Override
    public Demographie getDemographieByGeomIntersectPoint(Point point) {
       return demographieRepository.getDemographieByGeomIntersectPoint(point);
    }

    @Override
    public Demographie getDemographieByGeomIntersectGeoJsonPoint(GeoJsonPoint point) {
         return demographieRepository.getDemographieByGeomIntersectGeoJsonPoint(point);
    }

    @Override
    public List<Demographie> findDemographieAll() {
       return demographieRepository.findAll();
    }

    @Override
    public void test() {
        demographieRepository.test();
    }
    
}
