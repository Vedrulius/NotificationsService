package com.mihey.notification.service.impl;

import com.google.gson.Gson;
import com.mihey.notification.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class MessageListenerService {

    private NotificationServiceImpl service;

    @Autowired
    public MessageListenerService(NotificationServiceImpl service) {
        this.service = service;
    }

    @SqsListener("spring-aws-sqs")
    public void receiveMessage(String json, @Header("SenderId") String senderId) {
        Gson gson = new Gson();
        Notification notification = gson.fromJson(json, Notification.class);
        service.saveNotification(notification);
    }
}
