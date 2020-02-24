package com.lamine.projetmq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Queue;

@RestController
@RequestMapping("/test/publish")
public class producerResource {
    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    ActiveMQQueue queue;
    @GetMapping("{mess}")
    public String getMessage(@PathVariable("mess")
                                            final String message )
    {
        jmsTemplate.convertAndSend(queue,message);
        return "message envoyé";

    }
    
    @GetMapping("/test")
    public void getTest()
    {
        System.out.println ("message envoyé");
    }
}
