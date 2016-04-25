/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.MentionResponsabilite;
import ht.mbds.haiti.rase.model.repository.MentionResponsabiliteRepository;
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
public class MentionResponsabiliteServiceImpl implements MentionResponsabiliteService {
     @Autowired private MentionResponsabiliteRepository  MentionResponsabiliteRepository ;
     
     // MentionResponsabilite part 
    
    @Override
    public MentionResponsabilite findMentionResponsabiliteById(String id) {
        return  MentionResponsabiliteRepository.findOne(id);
    }

    @Override
    public MentionResponsabilite findMentionResponsabiliteByNom(String nom) {
         return  MentionResponsabiliteRepository.findByNom(nom);
    }

    @Override
    public List<MentionResponsabilite> findMentionResponsabiliteAll() {
     return  MentionResponsabiliteRepository.findAll();
    }

    @Override
    public MentionResponsabilite saveMentionResponsabilite(MentionResponsabilite  MentionResponsabilite) {
      return  MentionResponsabiliteRepository.save( MentionResponsabilite);
    }

    @Override
    public void deleteMentionResponsabilite(MentionResponsabilite  MentionResponsabilite) {
        MentionResponsabiliteRepository.delete( MentionResponsabilite);
    }

    @Override
    public void deleteMentionResponsabilite(String id) {
         MentionResponsabiliteRepository.delete(id);
    }

}
