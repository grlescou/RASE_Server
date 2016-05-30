/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.model.HistoriqueDetection;
import ht.mbds.haiti.rase.service.HistoriqueDetectionService;
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
@RequestMapping(value="/v1/historiqueDetection")
public class HistoriqueDetectionController {
      //message success
    static final String success_message_historiqueDetection_create = "La historiqueDetection a été créée avec succès";
    static final String success_message_historiqueDetection_update = "La historiqueDetection a été modifiée avec succès";
    static final String success_message_historiqueDetection_delete = "La historiqueDetection a été supprimée avec succès";
    // message fail
    static final String fail_message_historiqueDetection_create = "Echec de création de la historiqueDetection";
    static final String fail_message_historiqueDetection_update = "Echec de modification de la historiqueDetection";
    static final String fail_message_historiqueDetection_delete = "Echec de suppression de la historiqueDetection";
    
    @Autowired private HistoriqueDetectionService historiqueDetectionService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public HistoriqueDetection[] getHistoriqueDetectionArray() {
        return historiqueDetectionService.findHistoriqueDetectionAll().toArray(new HistoriqueDetection[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public HistoriqueDetection getHistoriqueDetectionById(@PathVariable("Id") String Id) {     
        HistoriqueDetection historiqueDetection = historiqueDetectionService.findHistoriqueDetectionById(Id) ;
        return historiqueDetection;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public Message createHistoriqueDetection(@Valid @RequestBody HistoriqueDetection historiqueDetection) {
        Message<HistoriqueDetection> message= null;
        try
        {
            HistoriqueDetection savedHistoriqueDetection = historiqueDetectionService.saveHistoriqueDetection(historiqueDetection);
            message = new Message<HistoriqueDetection>(success_message_historiqueDetection_create,true,savedHistoriqueDetection);
            return message;
        }
        catch(Exception ex)
        {
            message = new Message<HistoriqueDetection>(fail_message_historiqueDetection_create,false,null);
            return message;
        }
        
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public SimpleMessage updateHistoriqueDetection(@PathVariable("Id") String historiqueDetectionId,
                              @RequestBody HistoriqueDetection historiqueDetection) {
        SimpleMessage message =null;
        try
        {
            historiqueDetection.setId(historiqueDetectionId);
            historiqueDetectionService.saveHistoriqueDetection(historiqueDetection);
            message= new SimpleMessage(success_message_historiqueDetection_update,true);
            return message;
        }
        catch(Exception ex)
        {
            message= new SimpleMessage(fail_message_historiqueDetection_update,true);
            return message;
        }
       
       
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE,produces={APPLICATION_JSON_VALUE})
    public SimpleMessage deleteHistoriqueDetection(@PathVariable("Id") String historiqueDetectionId) {
         SimpleMessage message =null;
         try
         {
             historiqueDetectionService.deleteHistoriqueDetection(historiqueDetectionId);
             message= new SimpleMessage(success_message_historiqueDetection_delete,true);
             return message;
         }
         catch(Exception ex)
         {
             message= new SimpleMessage(fail_message_historiqueDetection_delete,true);
             return message;
         }
        
    }

}
