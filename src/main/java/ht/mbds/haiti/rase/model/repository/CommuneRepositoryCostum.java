/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.Commune;
import ht.mbds.haiti.rase.model.model.Demographie;
import ht.mbds.haiti.rase.model.model.Departement;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author gaetan
 */
public interface CommuneRepositoryCostum {
    
     public List<Commune> getCommuneDemographieCM(Long idMaladie, String dateDebut,String dateFin, String Mention, int note);
  
    
    
}
