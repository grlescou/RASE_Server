/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.repository;

import ht.mbds.haiti.rase.model.CasMaladie;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author MyPC
 */
public interface CasMaladieRepository extends MongoRepository<CasMaladie,String>{
     public List<CasMaladie> findByMaladieId(String Id);
     public List<CasMaladie> findByMaladieNom(String nom);
//     public List<CasMaladie> findBySymptomesId(long Id);
//     public List<CasMaladie> findBySymptomesNom(String nom);
}
