/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.model.MentionResponsabilite;
import ht.mbds.haiti.rase.service.MentionResponsabiliteService;
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
import ht.mbds.haiti.rase.utils.Message;
import ht.mbds.haiti.rase.utils.SimpleMessage;
/**
 *
 * @author gaetan
 */

@RestController
@RequestMapping(value="/v1/mention")
public class MentionResponsabiliteController {
    
    //message success
    static final String success_message_mention_create = "La mention a été créée avec succès";
    static final String success_message_mention_update = "La mention a été modifiée avec succès";
    static final String success_message_mention_delete = "La mention a été supprimée avec succès";
    // message fail
    static final String fail_message_mention_create = "Echec de création de la mention";
    static final String fail_message_mention_update = "Echec de modification de la mention";
    static final String fail_message_mention_delete = "Echec de suppression de la mention";
    
    @Autowired private MentionResponsabiliteService mentionService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public MentionResponsabilite[] getMentionResponsabiliteArray() {
        return mentionService.findMentionResponsabiliteAll().toArray(new MentionResponsabilite[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public MentionResponsabilite getMentionResponsabiliteById(@PathVariable("Id") String Id) {     
        MentionResponsabilite mention = mentionService.findMentionResponsabiliteById(Id) ;
        return mention;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public Message createMentionResponsabilite(@Valid @RequestBody MentionResponsabilite mention) {
        Message<MentionResponsabilite> message = null;
        try
        {
             MentionResponsabilite savedMentionResponsabilite = mentionService.saveMentionResponsabilite(mention);
             message= new Message<>(success_message_mention_create,true,savedMentionResponsabilite);
             return message;
        }
        catch(Exception ex)
        {
            message= new Message<>(fail_message_mention_create,false,null);
             return message;
        }
       
       
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public SimpleMessage updateMentionResponsabilite(@PathVariable("Id") String mentionId,
                              @RequestBody MentionResponsabilite mention) { 
        SimpleMessage message=null;
        try
        {
             mention.setId(mentionId);
             mentionService.saveMentionResponsabilite(mention);
             message=new SimpleMessage(success_message_mention_update,true);
             return message;
        }
        catch(Exception ex)
        {
             message=new SimpleMessage(fail_message_mention_update,true);
             return message;
        }
       
        
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE,produces={APPLICATION_JSON_VALUE})
    public SimpleMessage deleteMentionResponsabilite(@PathVariable("Id") String mentionId) {
         SimpleMessage message=null;
        try
        {
            mentionService.deleteMentionResponsabilite(mentionId);
            message=new SimpleMessage(success_message_mention_delete,true);
            return message;
        }
        catch(Exception ex)
        {
            message=new SimpleMessage(fail_message_mention_delete,true);
            return message;
        }
        
    }

}


