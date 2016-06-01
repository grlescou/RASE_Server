/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Demographie;
import ht.mbds.haiti.rase.model.repository.CommuneRepository;
import ht.mbds.haiti.rase.model.repository.DemographieRepository;
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
public class SectionCommunaleServiceImpl implements SectionCommunaleService{
    
    @Autowired private DemographieRepository demographieRepository;
    
    @Override
     public List<Demographie> getSectionCommunale (long  idMaldie, String dateDebut,String dateFin, String Mention, int note){
         return  demographieRepository.getSectionCommunaleDemographieCM(idMaldie, dateDebut,dateFin,Mention,note);
     }
    
     
}
