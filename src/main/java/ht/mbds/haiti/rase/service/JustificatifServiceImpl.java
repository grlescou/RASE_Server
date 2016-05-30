/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Justificatif;
import ht.mbds.haiti.rase.model.repository.JustificatifRepository;
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
public class JustificatifServiceImpl  implements JustificatifService {

    @Autowired private JustificatifRepository justificatifRepository;
    
    @Override
    public Justificatif findJustificatifById(String id) {
      return justificatifRepository.findOne(id);
    }

    @Override
    public List<Justificatif>  findJustificatifByUserId(String idUser) {
        return justificatifRepository.findByUserId(idUser);
    }

    @Override
    public List<Justificatif> findJustificatifAll() {
       return justificatifRepository.findAll();
    }

    @Override
    public Justificatif saveJustificatif(Justificatif justificatif) {
       return justificatifRepository.save(justificatif);
    }

    @Override
    public void deleteJustificatif(Justificatif justificatif) {
       justificatifRepository.delete(justificatif);
    }

    @Override
    public void deleteJustificatif(String id) {
       justificatifRepository.delete(id);
    }
    
}
