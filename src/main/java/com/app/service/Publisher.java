package com.app.service;

import com.app.model.Notification;
import com.app.pubsub.config.RabbitMqConfigProperties;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("publisher")
@Component
public class Publisher {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private FanoutExchange fanout;

    @Autowired
    private RabbitMqConfigProperties rabbitMqConfigProperties;

    public void publishMessage(Notification notification) {
        System.out.println("sending notification " + this.fanout.getName() + " " + notification.toString());

        this.amqpTemplate.convertAndSend(this.fanout.getName(), "", notification);
    }

}
