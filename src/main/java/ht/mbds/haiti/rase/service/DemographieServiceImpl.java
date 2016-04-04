/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Demographie;
import ht.mbds.haiti.rase.model.model.PersonnelSante;
import ht.mbds.haiti.rase.model.model.Utilisateur;
import ht.mbds.haiti.rase.model.model.utils.CasMaladieMR;
import ht.mbds.haiti.rase.model.repository.CasMaladieRepository;
import ht.mbds.haiti.rase.model.repository.DemographieRepository;
import ht.mbds.haiti.rase.utils.GeoLocation;
import ht.mbds.haiti.rase.utils.Message;
import ht.mbds.haiti.rase.utils.SimpleMessage;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gaetan
 */
@Service
@Transactional
public class DemographieServiceImpl implements DemographieService {

    @Autowired private DemographieRepository demographieRepository;
     @Autowired private CasMaladieRepository casMaladieRepo;
    
    @Override
    public Demographie getDemographieByGeomIntersectPoint(GeoLocation Glocation) {
       return demographieRepository.getDemographieByGeomIntersectPoint(Glocation);
    }

    

    @Override
    public List<Demographie> findDemographieAll() {
       return demographieRepository.findAll();
    }

    @Override
    public void test() {
        demographieRepository.test();
    }

    @Override
    public SimpleMessage createUtilisateur() {
       
      boolean ok = demographieRepository.createUtilisateur();
       
      if (ok)
        return new SimpleMessage("terminer avec success",ok);
      else
          return new SimpleMessage("terminer avec error",ok);
    }

    @Override
    public SimpleMessage createCategorie() {
        return demographieRepository.creerCategorie();
    }

//    @Override
//    public List<CasMaladieMR> getCasMaladieMR(long idMaldie) {
//        List<CasMaladieMR> listCasMaladieMRs = new ArrayList<CasMaladieMR>(casMaladieRepo.getCasMaladieMR(idMaldie).values());
//       return listCasMaladieMRs;
//    }
//    
    
    
    
    
}
