/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Role;
import java.util.List;

/**
 *
 * @author gaetan
 */
public interface RoleService {
    public Role findRoleById(String id);
    
     public Role findRoleByPrivilege(String privilege);
     
     public List<Role> findRoleAll();
    
     public Role saveRole ( Role role);
     
     public void deleteRole (Role role);
     
     public void deleteRole (String id);
}
