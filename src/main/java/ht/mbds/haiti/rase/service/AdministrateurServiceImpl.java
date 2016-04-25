/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Administrateur;
import ht.mbds.haiti.rase.model.repository.AdministrateurRepository;
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
public class AdministrateurServiceImpl implements AdministrateurService {
    @Autowired private AdministrateurRepository administrateurRepository;
    
      @Override
    public Administrateur findAdministrateurById(String id) {
        return administrateurRepository.findOne(id);
    }

    @Override
    public Administrateur findAdministrateurByMail(String mail) {
        return administrateurRepository.findByMail(mail);
    }

    @Override
    public List<Administrateur> findAdministrateurAll() {
        return administrateurRepository.findByRolePrivilege("Administrateur");
    }

    @Override
    public Administrateur saveAdministrateur(Administrateur user) {
       return  administrateurRepository.save(user);
    }

    @Override
    public void deleteAdministrateur(Administrateur user) {
       administrateurRepository.delete(user);
    }

    @Override
    public void deleteAdministrateur(String id) {
       administrateurRepository.delete(id);
    }
    
    
}
