package com.balthazar.Messaging_System.message.provider;

import com.balthazar.Messaging_System.message.entity.Message;
import com.balthazar.Messaging_System.message.provider.contract.MessageProvider;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsProvider implements MessageProvider {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromPhone;

    @PostConstruct
    public void initTwilio() {
        Twilio.init(accountSid, authToken);
    }

    @Override
    public void send(Message message) {

        com.twilio.rest.api.v2010.account.Message twilioMessage =
                com.twilio.rest.api.v2010.account.Message.creator(
                        new PhoneNumber(""), // toPhone
                        new PhoneNumber(fromPhone),
                        message.getDescription()
                ).create();

        System.out.println(
                "SMS enviado! SID: " + twilioMessage.getSid()
        );
    }
}