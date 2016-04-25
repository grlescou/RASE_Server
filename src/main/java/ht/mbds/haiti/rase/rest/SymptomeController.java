/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.model.Symptome;
import ht.mbds.haiti.rase.service.SymptomeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ht.mbds.haiti.rase.service.UtilisateurService;
import ht.mbds.haiti.rase.utils.Message;
import ht.mbds.haiti.rase.utils.SimpleMessage;
/**
 *
 * @author gaetan
 */

@RestController
@RequestMapping(value="/v1/symptome")
public class SymptomeController {
    
    //message success
    static final String success_message_symptome_create = "Le symptome a été créé avec succès";
    static final String success_message_symptome_update = "Le symptome a été modifié avec succès";
    static final String success_message_symptome_delete = "Le symptome a été supprimé avec succès";
    // message fail
    static final String fail_message_symptome_create = "Echec de création du symptome";
    static final String fail_message_symptome_update = "Echec de modification du symptome";
    static final String fail_message_symptome_delete = "Echec de suppression du symptome";
    
    @Autowired private SymptomeService symptomeService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public Symptome[] getSymptomeArray() {
        return symptomeService.findSymptomeAll().toArray(new Symptome[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Symptome getSymptomeById(@PathVariable("Id") String Id) {     
        Symptome user = symptomeService.findSymptomeById(Id) ;
        return user;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public Message createSymptome(@Valid @RequestBody Symptome symptome) {
        Message<Symptome> message= null;
        try
        {
             Symptome savedSymptome = symptomeService.saveSymptome(symptome);
             message= new Message<Symptome>(success_message_symptome_create,true,savedSymptome);
             return message;
             
        }
        catch(Exception ex)
        {
            message= new Message<Symptome>(fail_message_symptome_create,true,null);
            return message;
        }
         
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public SimpleMessage updateSymptome(@PathVariable("Id") String symptomeId,
                              @RequestBody Symptome symptome) { 
         SimpleMessage message = null;
        try
        {
            symptome.setId(symptomeId);
            symptomeService.saveSymptome(symptome);
            message = new SimpleMessage(success_message_symptome_update,true);
            return message;
            
        }
        catch(Exception ex)
        {
             message = new SimpleMessage(fail_message_symptome_update,true);
             return message;
        }
       
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE,produces={APPLICATION_JSON_VALUE})
    public SimpleMessage deleteSymptome(@PathVariable("Id") String symptomeId) {
         SimpleMessage message = null;
         try
         {
             symptomeService.deleteSymptome(symptomeId);
             message = new SimpleMessage(success_message_symptome_delete,true);
             return message;
         }
         catch(Exception ex)
         {
             message = new SimpleMessage(fail_message_symptome_delete,true);
             return message;
         }
        
    }

}






