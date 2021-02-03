package com.mihey.notification.service.impl;

import com.mihey.notification.NotificationApplication;
import com.mihey.notification.model.Notification;
import com.mihey.notification.repository.NotificationRepository;
import com.mihey.notification.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private NotificationRepository notificationRepository;
    Logger logger = LoggerFactory.getLogger(NotificationApplication.class);

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<Notification> getNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id).get();
    }

    @Override
    public Notification saveNotification(Notification notification) {
        if (notification != null) {
            notificationRepository.save(notification);
            logger.info("Notification: {}", notification);
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Notification not found!");
            }
        }
        return notification;
    }

    @Override
    public Notification updateNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void deleteNotificationById(Long id) {
        if (notificationRepository.existsById(id)) {
            notificationRepository.deleteById(id);
        }
    }
}
