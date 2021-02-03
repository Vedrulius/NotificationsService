package com.mihey.notification.service;

import com.mihey.notification.model.Notification;

import java.util.List;

public interface NotificationService {

    List<Notification> getNotifications();

    Notification getNotificationById(Long id);

    Notification saveNotification(Notification notification);

    Notification updateNotification(Notification notification);

    void deleteNotificationById(Long id);
}
