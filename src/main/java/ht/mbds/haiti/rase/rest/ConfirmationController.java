/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.model.Confirmation;
import ht.mbds.haiti.rase.service.ConfirmationService;
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
@RequestMapping(value="/v1/confirmation")
public class ConfirmationController {
      //message success
    static final String success_message_confirmation_create = "La confirmation a été créée avec succès";
    static final String success_message_confirmation_update = "La confirmation a été modifiée avec succès";
    static final String success_message_confirmation_delete = "La confirmation a été supprimée avec succès";
    // message fail
    static final String fail_message_confirmation_create = "Echec de création de la confirmation";
    static final String fail_message_confirmation_update = "Echec de modification de la confirmation";
    static final String fail_message_confirmation_delete = "Echec de suppression de la confirmation";
    
    @Autowired private ConfirmationService confirmationService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public Confirmation[] getConfirmationArray() {
        return confirmationService.findConfirmationAll().toArray(new Confirmation[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Confirmation getConfirmationById(@PathVariable("Id") String Id) {     
        Confirmation confirmation = confirmationService.findConfirmationById(Id) ;
        return confirmation;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public Message createConfirmation(@Valid @RequestBody Confirmation malaide) {
        Message<Confirmation> message= null;
        try
        {
            Confirmation savedConfirmation = confirmationService.saveConfirmation(malaide);
            message = new Message<Confirmation>(success_message_confirmation_create,true,savedConfirmation);
            return message;
        }
        catch(Exception ex)
        {
            message = new Message<Confirmation>(fail_message_confirmation_create,false,null);
            return message;
        }
        
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public SimpleMessage updateConfirmation(@PathVariable("Id") String confirmationId,
                              @RequestBody Confirmation confirmation) {
        SimpleMessage message =null;
        try
        {
            confirmation.setId(confirmationId);
            confirmationService.saveConfirmation(confirmation);
            message= new SimpleMessage(success_message_confirmation_update,true);
            return message;
        }
        catch(Exception ex)
        {
            message= new SimpleMessage(fail_message_confirmation_update,true);
            return message;
        }
       
       
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE,produces={APPLICATION_JSON_VALUE})
    public SimpleMessage deleteConfirmation(@PathVariable("Id") String confirmationId) {
         SimpleMessage message =null;
         try
         {
             confirmationService.deleteConfirmation(confirmationId);
             message= new SimpleMessage(success_message_confirmation_delete,true);
             return message;
         }
         catch(Exception ex)
         {
             message= new SimpleMessage(fail_message_confirmation_delete,true);
             return message;
         }
        
    }

}
