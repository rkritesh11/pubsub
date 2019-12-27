package com.app.pubsub.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Autowired
    RabbitMqConfigProperties rabbitMqConfigProperties;

    @Bean
    public Queue queue() {
        return new Queue(rabbitMqConfigProperties.getQueueName(), true);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(rabbitMqConfigProperties.getExchange());
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(rabbitMqConfigProperties.getRoutingkey());
    }
}