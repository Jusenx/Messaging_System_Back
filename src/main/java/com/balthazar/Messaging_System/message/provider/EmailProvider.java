package com.balthazar.Messaging_System.message.provider;

import com.balthazar.Messaging_System.message.entity.Message;
import com.balthazar.Messaging_System.message.provider.contract.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailProvider implements MessageProvider {

    @Value("${spring.mail.username}")
    private String fromMail;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void send(Message message) {

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(message.getSendTo());
        email.setSubject(message.getTitle());
        email.setText(message.getDescription());
        email.setFrom(fromMail);
        mailSender.send(email);

        System.out.println(
                "Enviando EMAIL: " + message.getDescription()
        );

    }
}