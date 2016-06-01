/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Commune;
import ht.mbds.haiti.rase.model.model.Departement;
import ht.mbds.haiti.rase.model.repository.CommuneRepository;
import ht.mbds.haiti.rase.model.repository.DepartementRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gaetan
 */

@Service
@Transactional
public class CommuneServiceImpl implements CommuneService {
    
     @Autowired private CommuneRepository communeRepository;
     
     @Override
      public List<Commune> getCommune (long  idMaldie, String dateDebut,String dateFin, String Mention, int note ){
          
          return communeRepository.getCommuneDemographieCM(idMaldie, dateDebut,dateFin,Mention,note);
          
      }
    
    
}
