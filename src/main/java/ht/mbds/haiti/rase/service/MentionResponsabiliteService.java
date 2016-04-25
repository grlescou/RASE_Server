/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.MentionResponsabilite;
import java.util.List;

/**
 *
 * @author gaetan
 */
public interface MentionResponsabiliteService {
    //MentionResponsabilite
     public MentionResponsabilite findMentionResponsabiliteById(String id);
    
     public MentionResponsabilite findMentionResponsabiliteByNom(String nom);
     
     public List<MentionResponsabilite> findMentionResponsabiliteAll();
    
     public MentionResponsabilite saveMentionResponsabilite ( MentionResponsabilite profession);
     
     public void deleteMentionResponsabilite (MentionResponsabilite profession);
     
     public void deleteMentionResponsabilite (String id);
}
