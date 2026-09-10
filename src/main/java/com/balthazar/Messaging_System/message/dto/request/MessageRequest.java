package com.balthazar.Messaging_System.message.dto.request;

import com.balthazar.Messaging_System.message.enums.ProviderEnum;

public record MessageRequest(
        String title,
        String description,
        String sendTo,
        ProviderEnum provider
) {
}
