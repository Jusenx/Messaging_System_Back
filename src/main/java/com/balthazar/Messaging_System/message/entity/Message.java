package com.balthazar.Messaging_System.message.entity;

import com.balthazar.Messaging_System.message.enums.ProviderEnum;
import com.balthazar.Messaging_System.message.enums.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String description;
    private String sendTo;
    private ProviderEnum provider;

    @Setter
    private StatusEnum status;

    public Message(String title, String description, String sendTo, ProviderEnum provider) {
        this.title = title;
        this.description = description;
        this.sendTo = sendTo;
        this.provider = provider;
    }
}