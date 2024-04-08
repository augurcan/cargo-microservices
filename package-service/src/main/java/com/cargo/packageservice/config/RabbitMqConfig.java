package com.cargo.packageservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    String exchange="default";

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Queue locationAddQueue(){
        return new Queue("locationAddQueue", true);
    }
    @Bean
    Queue userQueue() {
        return new Queue("userQueue", true);
    }
    @Bean
    Binding locationBinding(Queue locationAddQueue, DirectExchange exchange){
        return BindingBuilder.bind(locationAddQueue).to(exchange).with("locationAddRoute");
    }

    @Bean
    Binding userBinding(Queue userQueue, DirectExchange exchange){
        return BindingBuilder.bind(userQueue).to(exchange).with("userRoute");
    }

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
