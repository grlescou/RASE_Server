/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.model.Souscription;
import ht.mbds.haiti.rase.service.SouscriptionService;
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
@RequestMapping(value="/v1/souscription")
public class SouscriptionController {
   
     //message success
    static final String success_message_souscription_create = "La souscription a été créée avec succès";
    static final String success_message_souscription_update = "La souscription a été modifiée avec succès";
    static final String success_message_souscription_delete = "La souscription a été supprimée avec succès";
    // message fail
    static final String fail_message_souscription_create = "Echec de création de la souscription";
    static final String fail_message_souscription_update = "Echec de modification de la souscription";
    static final String fail_message_souscription_delete = "Echec de suppression de la souscription";
    
    @Autowired private SouscriptionService souscriptionService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public Souscription[] getSouscriptionArray() {
        return souscriptionService.findSouscriptionAll().toArray(new Souscription[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Souscription getSouscriptionById(@PathVariable("Id") String Id) {     
        Souscription souscription = souscriptionService.findSouscriptionById(Id) ;
        return souscription;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public Message createSouscription(@Valid @RequestBody Souscription malaide) {
        Message<Souscription> message= null;
        try
        {
            Souscription savedSouscription = souscriptionService.saveSouscription(malaide);
            message = new Message<Souscription>(success_message_souscription_create,true,savedSouscription);
            return message;
        }
        catch(Exception ex)
        {
            message = new Message<Souscription>(fail_message_souscription_create,false,null);
            return message;
        }
        
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public SimpleMessage updateSouscription(@PathVariable("Id") String souscriptionId,
                              @RequestBody Souscription souscription) {
        SimpleMessage message =null;
        try
        {
            souscription.setId(souscriptionId);
            souscriptionService.saveSouscription(souscription);
            message= new SimpleMessage(success_message_souscription_update,true);
            return message;
        }
        catch(Exception ex)
        {
            message= new SimpleMessage(fail_message_souscription_update,true);
            return message;
        }
       
       
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE,produces={APPLICATION_JSON_VALUE})
    public SimpleMessage deleteSouscription(@PathVariable("Id") String souscriptionId) {
         SimpleMessage message =null;
         try
         {
             souscriptionService.deleteSouscription(souscriptionId);
             message= new SimpleMessage(success_message_souscription_delete,true);
             return message;
         }
         catch(Exception ex)
         {
             message= new SimpleMessage(fail_message_souscription_delete,true);
             return message;
         }
        
    }

    
}
