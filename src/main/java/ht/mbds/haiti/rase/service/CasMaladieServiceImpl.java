/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.CasMaladie;
import ht.mbds.haiti.rase.repository.CasMaladieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MyPC
 */
@Service
@Transactional
public class CasMaladieServiceImpl implements CasMaladieService {

    @Autowired private CasMaladieRepository casMaladieRepository;
    
    @Override
    public CasMaladie findCasMaladieById(long id) {
      return  casMaladieRepository.findOne(id);
    }

    @Override
    public List<CasMaladie> findCasMaladieByMaladieId(long Id) {
        return  casMaladieRepository.findByMaladieId(Id);
    }

    @Override
    public List<CasMaladie> findCasMaladieByMaladieNom(String nom) {
        return  casMaladieRepository.findByMaladieNom(nom);
    }
/*
    @Override
    public List<CasMaladie> findCasMaladieBySymptomesId(long Id) {
        return  casMaladieRepository.findBySymptomesId(Id);
    }

    @Override
    public List<CasMaladie> findCasMaladieBySymptomesNom(String nom) {
        return  casMaladieRepository.findBySymptomesNom(nom);
    }
*/
    @Override
    public List<CasMaladie> findCasMaladieAll() {
        return  casMaladieRepository.findAll();
    }

    @Override
    public CasMaladie saveCasMaladie(CasMaladie casMaladie) {
        return  casMaladieRepository.save(casMaladie);
    }

    @Override
    public void deleteCasMaladie(CasMaladie casMaladie) {
      casMaladieRepository.delete(casMaladie);
    }

    @Override
    public void deleteCasMaladie(long id) {
       casMaladieRepository.delete(id);
    }
    
    
    
}
