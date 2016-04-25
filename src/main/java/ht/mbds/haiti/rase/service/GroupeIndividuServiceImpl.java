/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.GroupeIndividu;
import ht.mbds.haiti.rase.model.repository.GroupeIndividuRepository;
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
public class GroupeIndividuServiceImpl implements GroupeIndividuService{
    
     @Autowired private GroupeIndividuRepository  GroupeIndividuRepository ;
     
     // GroupeIndividu part 
    
    @Override
    public GroupeIndividu findGroupeIndividuById(String id) {
        return  GroupeIndividuRepository.findOne(id);
    }

    @Override
    public GroupeIndividu findGroupeIndividuByNom(String nom) {
         return  GroupeIndividuRepository.findByNomGroupe(nom);
    }

    @Override
    public List<GroupeIndividu> findGroupeIndividuAll() {
     return  GroupeIndividuRepository.findAll();
    }

    @Override
    public GroupeIndividu saveGroupeIndividu(GroupeIndividu  groupeIndividu) {
      return  GroupeIndividuRepository.save( groupeIndividu);
    }

    @Override
    public void deleteGroupeIndividu(GroupeIndividu  groupeIndividu) {
        GroupeIndividuRepository.delete( groupeIndividu);
    }

    @Override
    public void deleteGroupeIndividu(String id) {
         GroupeIndividuRepository.delete(id);
    }

}
