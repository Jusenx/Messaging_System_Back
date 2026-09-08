package com.balthazar.Messaging_System.message.entity;

import com.balthazar.Messaging_System.message.enums.ProviderEnum;
import com.balthazar.Messaging_System.message.enums.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String description;
    private final ProviderEnum provider;

    @Setter
    private StatusEnum status;

    public Message(String title, String description, ProviderEnum provider) {
        this.title = title;
        this.description = description;
        this.provider = provider;
    }

}
