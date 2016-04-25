/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Role;
import ht.mbds.haiti.rase.model.repository.RoleRepository;
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
public class RoleServiceImpl implements RoleService {
     @Autowired private RoleRepository  RoleRepository ;
     
     // Role part 
    
    @Override
    public Role findRoleById(String id) {
        return  RoleRepository.findOne(id);
    }

    @Override
    public Role findRoleByPrivilege(String privilege) {
         return  RoleRepository.findByPrivilege(privilege);
    }

    @Override
    public List<Role> findRoleAll() {
     return  RoleRepository.findAll();
    }

    @Override
    public Role saveRole(Role  Role) {
      return  RoleRepository.save( Role);
    }

    @Override
    public void deleteRole(Role  Role) {
        RoleRepository.delete( Role);
    }

    @Override
    public void deleteRole(String id) {
         RoleRepository.delete(id);
    }

}
