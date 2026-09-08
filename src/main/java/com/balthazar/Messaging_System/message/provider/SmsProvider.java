package com.balthazar.Messaging_System.message.provider;

import com.balthazar.Messaging_System.message.entity.Message;
import com.balthazar.Messaging_System.message.provider.contract.MessageProvider;
import org.springframework.stereotype.Component;

@Component
public class SmsProvider implements MessageProvider {

    @Override
    public void send(Message message) {

        System.out.println(
                "Enviando SMS: " + message.getDescription()
        );

    }
}