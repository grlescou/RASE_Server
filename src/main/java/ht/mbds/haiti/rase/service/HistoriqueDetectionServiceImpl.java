/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.HistoriqueDetection;
import ht.mbds.haiti.rase.model.repository.HistoriqueDetectionRepository;
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
public class HistoriqueDetectionServiceImpl implements HistoriqueDetectionService {

    @Autowired private HistoriqueDetectionRepository historiqueDetectionRepository;
    
    @Override
    public HistoriqueDetection findHistoriqueDetectionById(String id) {
      return historiqueDetectionRepository.findOne(id);
    }


    @Override
    public List<HistoriqueDetection> findHistoriqueDetectionAll() {
       return historiqueDetectionRepository.findAll();
    }

    @Override
    public HistoriqueDetection saveHistoriqueDetection(HistoriqueDetection historiqueDetection) {
       return historiqueDetectionRepository.save(historiqueDetection);
    }

    @Override
    public void deleteHistoriqueDetection(HistoriqueDetection historiqueDetection) {
       historiqueDetectionRepository.delete(historiqueDetection);
    }

    @Override
    public void deleteHistoriqueDetection(String id) {
       historiqueDetectionRepository.delete(id);
    }
    
    
}
