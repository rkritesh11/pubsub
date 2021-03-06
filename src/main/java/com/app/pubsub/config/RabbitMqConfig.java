package com.app.pubsub.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RabbitMqConfig {

    @Autowired
    RabbitMqConfigProperties rabbitMqConfigProperties;

    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange(rabbitMqConfigProperties.getExchange());
    }

    @Profile("consumer")
    private static class ConsumerConfig {

        @Bean
        public Queue autoDeleteQueue() {
            return new AnonymousQueue();
        }

        @Bean
        Binding binding(Queue autoDeleteQueue, FanoutExchange exchange) {
            return BindingBuilder.bind(autoDeleteQueue).to(exchange);
        }
    }
}