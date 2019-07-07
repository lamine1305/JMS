package com.lamine.projetmq.configurations;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class Config {

    @Value("${spring.activemq.broker-url}")
    String urlBroker;
    @Bean
    public ActiveMQQueue queue()
    {
        return new ActiveMQQueue("Lamine.queue");

    }
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory()
    {
          ActiveMQConnectionFactory factory =new ActiveMQConnectionFactory();
          factory.setBrokerURL(urlBroker);
            return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate()
    {
        return new JmsTemplate(activeMQConnectionFactory());
    }
}
