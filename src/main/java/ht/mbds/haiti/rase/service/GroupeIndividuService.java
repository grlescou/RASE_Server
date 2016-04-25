/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.GroupeIndividu;
import java.util.List;

/**
 *
 * @author gaetan
 */
public interface GroupeIndividuService {
     public GroupeIndividu findGroupeIndividuById(String id);
    
     public GroupeIndividu findGroupeIndividuByNom(String nom);
     
     public List<GroupeIndividu> findGroupeIndividuAll();
    
     public GroupeIndividu saveGroupeIndividu ( GroupeIndividu groupeIndividu);
     
     public void deleteGroupeIndividu (GroupeIndividu groupeIndividu);
     
     public void deleteGroupeIndividu (String id);
}
