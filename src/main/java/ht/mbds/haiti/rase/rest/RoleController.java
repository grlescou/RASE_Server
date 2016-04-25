/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.model.Role;
import ht.mbds.haiti.rase.service.RoleService;
import ht.mbds.haiti.rase.utils.Message;
import ht.mbds.haiti.rase.utils.SimpleMessage;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gaetan
 */
@RestController
@RequestMapping(value="/v1/role")
public class RoleController {
      //message success
    static final String success_message_role_create = "La role a été créée avec succès";
    static final String success_message_role_update = "La role a été modifiée avec succès";
    static final String success_message_role_delete = "La role a été supprimée avec succès";
    // message fail
    static final String fail_message_role_create = "Echec de création de la role";
    static final String fail_message_role_update = "Echec de modification de la role";
    static final String fail_message_role_delete = "Echec de suppression de la role";
    
    @Autowired private RoleService roleService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public Role[] getRoleArray() {
        return roleService.findRoleAll().toArray(new Role[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Role getRoleById(@PathVariable("Id") String Id) {     
        Role role = roleService.findRoleById(Id) ;
        return role;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public Message createRole(@Valid @RequestBody Role role) {
        Message<Role> message = null;
        try
        {
             Role savedRole = roleService.saveRole(role);
             message= new Message<Role>(success_message_role_create,true,savedRole);
             return message;
        }
        catch(Exception ex)
        {
            message= new Message<Role>(fail_message_role_create,false,null);
             return message;
        }
       
       
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public SimpleMessage updateRole(@PathVariable("Id") String roleId,
                              @RequestBody Role role) { 
        SimpleMessage message=null;
        try
        {
             role.setId(roleId);
             roleService.saveRole(role);
             message=new SimpleMessage(success_message_role_update,true);
             return message;
        }
        catch(Exception ex)
        {
             message=new SimpleMessage(fail_message_role_update,true);
             return message;
        }
       
        
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE,produces={APPLICATION_JSON_VALUE})
    public SimpleMessage deleteRole(@PathVariable("Id") String roleId) {
         SimpleMessage message=null;
        try
        {
            roleService.deleteRole(roleId);
            message=new SimpleMessage(success_message_role_delete,true);
            return message;
        }
        catch(Exception ex)
        {
            message=new SimpleMessage(fail_message_role_delete,true);
            return message;
        }
        
    } 
}
