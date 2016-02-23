/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.model.Profession;
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
 * @author MyPC
 */

@RestController
@RequestMapping(value="/v1/profession")
public class ProfessionController {
    
    //message success
    static final String success_message_profession_create = "La profession a été créée avec succès";
    static final String success_message_profession_update = "La profession a été modifiée avec succès";
    static final String success_message_profession_delete = "La profession a été supprimée avec succès";
    // message fail
    static final String fail_message_profession_create = "Echec de création de la profession";
    static final String fail_message_profession_update = "Echec de modification de la profession";
    static final String fail_message_profession_delete = "Echec de suppression de la profession";
    
    @Autowired private UtilisateurService professionService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public Profession[] getProfessionArray() {
        return professionService.findProfessionAll().toArray(new Profession[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Profession getProfessionById(@PathVariable("Id") String Id) {     
        Profession profession = professionService.findProfessionById(Id) ;
        return profession;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public Message createProfession(@Valid @RequestBody Profession profession) {
        Message<Profession> message = null;
        try
        {
             Profession savedProfession = professionService.saveProfession(profession);
             message= new Message<>(success_message_profession_create,true,savedProfession);
             return message;
        }
        catch(Exception ex)
        {
            message= new Message<>(fail_message_profession_create,false,null);
             return message;
        }
       
       
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE})
    public SimpleMessage updateProfession(@PathVariable("Id") String professionId,
                              @RequestBody Profession profession) { 
        SimpleMessage message=null;
        try
        {
             profession.setId(professionId);
             professionService.saveProfession(profession);
             message=new SimpleMessage(success_message_profession_update,true);
             return message;
        }
        catch(Exception ex)
        {
             message=new SimpleMessage(fail_message_profession_update,true);
             return message;
        }
       
        
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public SimpleMessage deleteProfession(@PathVariable("Id") String professionId) {
         SimpleMessage message=null;
        try
        {
            professionService.deleteProfession(professionId);
            message=new SimpleMessage(success_message_profession_delete,true);
            return message;
        }
        catch(Exception ex)
        {
            message=new SimpleMessage(fail_message_profession_delete,true);
            return message;
        }
        
    }

}


