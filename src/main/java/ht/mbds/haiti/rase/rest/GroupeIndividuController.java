/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.model.GroupeIndividu;
import ht.mbds.haiti.rase.service.GroupeIndividuService;
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
@RequestMapping(value="/v1/groupeIndividu")
public class GroupeIndividuController {
     //message success
    static final String success_message_groupeIndividu_create = "La Groupe Individu a été créée avec succès";
    static final String success_message_groupeIndividu_update = "La Groupe Individu a été modifiée avec succès";
    static final String success_message_groupeIndividu_delete = "La Groupe Individu a été supprimée avec succès";
    // message fail
    static final String fail_message_groupeIndividu_create = "Echec de création de la Groupe Individu";
    static final String fail_message_groupeIndividu_update = "Echec de modification de la Groupe Individu";
    static final String fail_message_groupeIndividu_delete = "Echec de suppression de la Groupe Individu";
    
    @Autowired private GroupeIndividuService groupeIndividuService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public GroupeIndividu[] getGroupeIndividuArray() {
        return groupeIndividuService.findGroupeIndividuAll().toArray(new GroupeIndividu[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public GroupeIndividu getGroupeIndividuById(@PathVariable("Id") String Id) {     
        GroupeIndividu groupeIndividu = groupeIndividuService.findGroupeIndividuById(Id) ;
        return groupeIndividu;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public Message createGroupeIndividu(@Valid @RequestBody GroupeIndividu groupeIndividu) {
        Message<GroupeIndividu> message = null;
        try
        {
             GroupeIndividu savedGroupeIndividu = groupeIndividuService.saveGroupeIndividu(groupeIndividu);
             message= new Message<>(success_message_groupeIndividu_create,true,savedGroupeIndividu);
             return message;
        }
        catch(Exception ex)
        {
            message= new Message<>(fail_message_groupeIndividu_create,false,null);
             return message;
        }
       
       
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public SimpleMessage updateGroupeIndividu(@PathVariable("Id") String groupeIndividuId,
                              @RequestBody GroupeIndividu groupeIndividu) { 
        SimpleMessage message=null;
        try
        {
             groupeIndividu.setId(groupeIndividuId);
             groupeIndividuService.saveGroupeIndividu(groupeIndividu);
             message=new SimpleMessage(success_message_groupeIndividu_update,true);
             return message;
        }
        catch(Exception ex)
        {
             message=new SimpleMessage(fail_message_groupeIndividu_update,true);
             return message;
        }
       
        
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE,produces={APPLICATION_JSON_VALUE})
    public SimpleMessage deleteGroupeIndividu(@PathVariable("Id") String groupeIndividuId) {
         SimpleMessage message=null;
        try
        {
            groupeIndividuService.deleteGroupeIndividu(groupeIndividuId);
            message=new SimpleMessage(success_message_groupeIndividu_delete,true);
            return message;
        }
        catch(Exception ex)
        {
            message=new SimpleMessage(fail_message_groupeIndividu_delete,true);
            return message;
        }
        
    }
}
