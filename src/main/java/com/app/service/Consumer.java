package com.app.service;

import com.app.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("consumer")
@Component
public class Consumer {

    @RabbitListener(queues = "#{autoDeleteQueue.name}")
    public void receiveMessage(Notification notification) {
        System.out.println("notification received" + notification.toString());
    }
}
