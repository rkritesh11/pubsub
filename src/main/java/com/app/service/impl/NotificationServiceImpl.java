package com.app.service.impl;

import com.app.model.Notification;
import com.app.service.NotificationService;
import com.app.service.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnBean(Publisher.class)
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private Publisher publisher;

    @Override
    public void sendNotification(Notification notification) {
        this.publisher.publishMessage(notification);
    }
}
