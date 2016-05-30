/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model. Notification;
import java.util.List;

/**
 *
 * @author gaetan
 */
public interface NotificationService {
     //  notification 
    
     public  Notification findNotificationById(String id);
    
     public  Notification findNotificationByDate(String nom);
     
     public List<Notification> findNotificationAll();
    
     public  Notification saveNotification (Notification  notification);
     
     public void deleteNotification ( Notification  notification);
     
     public void deleteNotification (String id);
    
}
