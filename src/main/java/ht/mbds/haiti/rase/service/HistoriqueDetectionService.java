/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.HistoriqueDetection;
import java.util.List;

/**
 *
 * @author gaetan
 */
public interface HistoriqueDetectionService {
     // historiqueDetection 
    
    public HistoriqueDetection findHistoriqueDetectionById(String id);
  
    
     public List<HistoriqueDetection> findHistoriqueDetectionAll();
    
     public HistoriqueDetection saveHistoriqueDetection ( HistoriqueDetection historiqueDetection);
     
     public void deleteHistoriqueDetection (HistoriqueDetection historiqueDetection);
     
     public void deleteHistoriqueDetection (String id);
}
