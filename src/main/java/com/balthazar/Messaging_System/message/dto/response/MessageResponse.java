package com.balthazar.Messaging_System.message.dto.response;

import com.balthazar.Messaging_System.message.enums.ProviderEnum;

public record MessageResponse(
        String title,
        String description,
        ProviderEnum provider
) {
}
