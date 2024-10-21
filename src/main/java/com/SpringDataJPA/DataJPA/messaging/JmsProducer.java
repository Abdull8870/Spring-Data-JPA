package com.SpringDataJPA.DataJPA.messaging;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class JmsProducer {

    private JmsTemplate jmsTemplate;

    public void sendMessage(String destination, String message) {
        jmsTemplate.convertAndSend(destination, message);
    }

    // @JmsListener(destination = "my-queue")
    // public void receiveMessage(String message) {
    //     System.out.println("Received message: " + message);
    // }


    @JmsListener(destination = "user_log")
    public void receiveUseLog(String message) {
        System.out.println("Received message: " + message);
    }

    
}
