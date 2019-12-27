package com.app.controller;

import com.app.model.Notification;
import com.app.service.NotificationService;
import com.app.service.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConditionalOnBean(Publisher.class)
public class NotificationController {

    @Autowired
    private NotificationService notificationService;


    @RequestMapping(value = "/sendNotification", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sendNotification(@RequestBody Notification notification) {
        this.notificationService.sendNotification(notification);
    }
}
