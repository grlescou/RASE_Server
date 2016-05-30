/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model. Notification;
import ht.mbds.haiti.rase.model.repository. NotificationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gaetan
 */

@Service
@Transactional
public class NotificationServiceImpl implements  NotificationService {

    @Autowired private  NotificationRepository  notificationRepository;
    
    @Override
    public  Notification findNotificationById(String id) {
      return  notificationRepository.findOne(id);
    }

    @Override
    public  Notification findNotificationByDate(String date) {
        return  notificationRepository.findByDate(date);
    }

    @Override
    public List< Notification> findNotificationAll() {
       return  notificationRepository.findAll();
    }

    @Override
    public  Notification saveNotification( Notification  notification) {
       return  notificationRepository.save( notification);
    }

    @Override
    public void deleteNotification( Notification  notification) {
        notificationRepository.delete( notification);
    }

    @Override
    public void deleteNotification(String id) {
        notificationRepository.delete(id);
    }
    
}
