/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.model.Justificatif;
import ht.mbds.haiti.rase.service.JustificatifService;
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
@RequestMapping(value="/v1/justificatif")
public class JustificatifController {
    
      //message success
    static final String success_message_justificatif_create = "La justificatif a été créée avec succès";
    static final String success_message_justificatif_update = "La justificatif a été modifiée avec succès";
    static final String success_message_justificatif_delete = "La justificatif a été supprimée avec succès";
    // message fail
    static final String fail_message_justificatif_create = "Echec de création de la justificatif";
    static final String fail_message_justificatif_update = "Echec de modification de la justificatif";
    static final String fail_message_justificatif_delete = "Echec de suppression de la justificatif";
    
    @Autowired private JustificatifService justificatifService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public Justificatif[] getJustificatifArray() {
        return justificatifService.findJustificatifAll().toArray(new Justificatif[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Justificatif getJustificatifById(@PathVariable("Id") String Id) {     
        Justificatif justificatif = justificatifService.findJustificatifById(Id) ;
        return justificatif;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public Message createJustificatif(@Valid @RequestBody Justificatif malaide) {
        Message<Justificatif> message= null;
        try
        {
            Justificatif savedJustificatif = justificatifService.saveJustificatif(malaide);
            message = new Message<Justificatif>(success_message_justificatif_create,true,savedJustificatif);
            return message;
        }
        catch(Exception ex)
        {
            message = new Message<Justificatif>(fail_message_justificatif_create,false,null);
            return message;
        }
        
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public SimpleMessage updateJustificatif(@PathVariable("Id") String justificatifId,
                              @RequestBody Justificatif justificatif) {
        SimpleMessage message =null;
        try
        {
            justificatif.setId(justificatifId);
            justificatifService.saveJustificatif(justificatif);
            message= new SimpleMessage(success_message_justificatif_update,true);
            return message;
        }
        catch(Exception ex)
        {
            message= new SimpleMessage(fail_message_justificatif_update,true);
            return message;
        }
       
       
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE,produces={APPLICATION_JSON_VALUE})
    public SimpleMessage deleteJustificatif(@PathVariable("Id") String justificatifId) {
         SimpleMessage message =null;
         try
         {
             justificatifService.deleteJustificatif(justificatifId);
             message= new SimpleMessage(success_message_justificatif_delete,true);
             return message;
         }
         catch(Exception ex)
         {
             message= new SimpleMessage(fail_message_justificatif_delete,true);
             return message;
         }
        
    }

    
}
