/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Commune;
import ht.mbds.haiti.rase.model.model.Demographie;
import java.util.List;

/**
 *
 * @author gaetan
 */
public interface SectionCommunaleService {
    
      public List<Demographie> getSectionCommunale (long  idMaldie, String dateDebut,String dateFin, String Mention, int note); 
    
}
