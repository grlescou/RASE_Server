/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

/**
 *
 * @author gaetan
 */

import ht.mbds.haiti.rase.model.model.Maladie;
import ht.mbds.haiti.rase.service.MaladieService;
import ht.mbds.haiti.rase.utils.Message;
import ht.mbds.haiti.rase.utils.SimpleMessage;
import javax.validation.Valid;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/v1/maladie")
public class MaladieController {
    
    //message success
    static final String success_message_maladie_create = "La maladie a été créée avec succès";
    static final String success_message_maladie_update = "La maladie a été modifiée avec succès";
    static final String success_message_maladie_delete = "La maladie a été supprimée avec succès";
    // message fail
    static final String fail_message_maladie_create = "Echec de création de la maladie";
    static final String fail_message_maladie_update = "Echec de modification de la maladie";
    static final String fail_message_maladie_delete = "Echec de suppression de la maladie";
    
    @Autowired private MaladieService maladieService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public Maladie[] getMaladieArray() {
        return maladieService.findMaladieAll().toArray(new Maladie[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Maladie getMaladieById(@PathVariable("Id") String Id) {     
        Maladie maladie = maladieService.findMaladieById(Id) ;
        return maladie;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public Message createMaladie(@Valid @RequestBody Maladie malaide) {
        Message<Maladie> message= null;
        try
        {
            Maladie savedMaladie = maladieService.saveMaladie(malaide);
            message = new Message<>(success_message_maladie_create,true,savedMaladie);
            return message;
        }
        catch(Exception ex)
        {
            message = new Message<>(fail_message_maladie_create,false,null);
            return message;
        }
        
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public SimpleMessage updateMaladie(@PathVariable("Id") String maladieId,
                              @RequestBody Maladie maladie) {
        SimpleMessage message =null;
        try
        {
            maladie.setId(maladieId);
            maladieService.saveMaladie(maladie);
            message= new SimpleMessage(success_message_maladie_update,true);
            return message;
        }
        catch(Exception ex)
        {
            message= new SimpleMessage(fail_message_maladie_update,true);
            return message;
        }
       
       
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE,produces={APPLICATION_JSON_VALUE})
    public SimpleMessage deleteMaladie(@PathVariable("Id") String maladieId) {
         SimpleMessage message =null;
         try
         {
             maladieService.deleteMaladie(maladieId);
             message= new SimpleMessage(success_message_maladie_delete,true);
             return message;
         }
         catch(Exception ex)
         {
             message= new SimpleMessage(fail_message_maladie_delete,true);
             return message;
         }
        
    }

    
}
