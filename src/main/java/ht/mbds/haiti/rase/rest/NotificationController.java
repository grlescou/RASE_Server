/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.model.Notification;
import ht.mbds.haiti.rase.service.NotificationService;
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
@RequestMapping(value="/v1/notification")
public class NotificationController {
      //message success
    static final String success_message_notification_create = "La notification a été créée avec succès";
    static final String success_message_notification_update = "La notification a été modifiée avec succès";
    static final String success_message_notification_delete = "La notification a été supprimée avec succès";
    // message fail
    static final String fail_message_notification_create = "Echec de création de la notification";
    static final String fail_message_notification_update = "Echec de modification de la notification";
    static final String fail_message_notification_delete = "Echec de suppression de la notification";
    
    @Autowired private NotificationService notificationService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public Notification[] getNotificationArray() {
        return notificationService.findNotificationAll().toArray(new Notification[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Notification getNotificationById(@PathVariable("Id") String Id) {     
        Notification notification = notificationService.findNotificationById(Id) ;
        return notification;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public Message createNotification(@Valid @RequestBody Notification malaide) {
        Message<Notification> message= null;
        try
        {
            Notification savedNotification = notificationService.saveNotification(malaide);
            message = new Message<Notification>(success_message_notification_create,true,savedNotification);
            return message;
        }
        catch(Exception ex)
        {
            message = new Message<Notification>(fail_message_notification_create,false,null);
            return message;
        }
        
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public SimpleMessage updateNotification(@PathVariable("Id") String notificationId,
                              @RequestBody Notification notification) {
        SimpleMessage message =null;
        try
        {
            notification.setId(notificationId);
            notificationService.saveNotification(notification);
            message= new SimpleMessage(success_message_notification_update,true);
            return message;
        }
        catch(Exception ex)
        {
            message= new SimpleMessage(fail_message_notification_update,true);
            return message;
        }
       
       
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE,produces={APPLICATION_JSON_VALUE})
    public SimpleMessage deleteNotification(@PathVariable("Id") String notificationId) {
         SimpleMessage message =null;
         try
         {
             notificationService.deleteNotification(notificationId);
             message= new SimpleMessage(success_message_notification_delete,true);
             return message;
         }
         catch(Exception ex)
         {
             message= new SimpleMessage(fail_message_notification_delete,true);
             return message;
         }
        
    }

}
