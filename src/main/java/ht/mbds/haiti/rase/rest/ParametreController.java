/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.model.Parametre;
import ht.mbds.haiti.rase.service.ParametreService;
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
@RequestMapping(value="/v1/parametre")
public class ParametreController {
    
     //message success
    static final String success_message_parametre_create = "La parametre a été créée avec succès";
    static final String success_message_parametre_update = "La parametre a été modifiée avec succès";
    static final String success_message_parametre_delete = "La parametre a été supprimée avec succès";
    // message fail
    static final String fail_message_parametre_create = "Echec de création de la parametre";
    static final String fail_message_parametre_update = "Echec de modification de la parametre";
    static final String fail_message_parametre_delete = "Echec de suppression de la parametre";
    
    @Autowired private ParametreService parametreService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public Parametre[] getParametreArray() {
        return parametreService.findParametreAll().toArray(new Parametre[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Parametre getParametreById(@PathVariable("Id") String Id) {     
        Parametre parametre = parametreService.findParametreById(Id) ;
        return parametre;
    }
    
    
     @RequestMapping(value="/{nom}/nom", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Parametre getParametreByNom(@PathVariable("nom") String nom) {     
        Parametre parametre = parametreService.findParametreByNom(nom) ;
        return parametre;
    }
    
    
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public Message createParametre(@Valid @RequestBody Parametre malaide) {
        Message<Parametre> message= null;
        try
        {
            Parametre savedParametre = parametreService.saveParametre(malaide);
            message = new Message<Parametre>(success_message_parametre_create,true,savedParametre);
            return message;
        }
        catch(Exception ex)
        {
            message = new Message<Parametre>(fail_message_parametre_create,false,null);
            return message;
        }
        
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public SimpleMessage updateParametre(@PathVariable("Id") String parametreId,
                              @RequestBody Parametre parametre) {
        SimpleMessage message =null;
        try
        {
            parametre.setId(parametreId);
            parametreService.saveParametre(parametre);
            message= new SimpleMessage(success_message_parametre_update,true);
            return message;
        }
        catch(Exception ex)
        {
            message= new SimpleMessage(fail_message_parametre_update,true);
            return message;
        }
       
       
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE,produces={APPLICATION_JSON_VALUE})
    public SimpleMessage deleteParametre(@PathVariable("Id") String parametreId) {
         SimpleMessage message =null;
         try
         {
             parametreService.deleteParametre(parametreId);
             message= new SimpleMessage(success_message_parametre_delete,true);
             return message;
         }
         catch(Exception ex)
         {
             message= new SimpleMessage(fail_message_parametre_delete,true);
             return message;
         }
        
    }

    
}
