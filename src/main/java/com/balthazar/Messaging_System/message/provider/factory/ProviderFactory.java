package com.balthazar.Messaging_System.message.provider.factory;

import com.balthazar.Messaging_System.message.entity.Message;
import com.balthazar.Messaging_System.message.provider.EmailProvider;
import com.balthazar.Messaging_System.message.provider.SmsProvider;
import com.balthazar.Messaging_System.message.provider.contract.MessageProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProviderFactory {

    private final EmailProvider emailProvider;
    private final SmsProvider smsProvider;

    public MessageProvider getProvider(Message message) {

        return switch (message.getProvider()) {
            case Email -> emailProvider;
            case SMS -> smsProvider;
        };
    }

}
