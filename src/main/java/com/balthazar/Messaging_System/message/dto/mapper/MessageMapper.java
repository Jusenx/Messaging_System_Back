package com.balthazar.Messaging_System.message.dto.mapper;

import com.balthazar.Messaging_System.message.dto.request.MessageRequest;
import com.balthazar.Messaging_System.message.dto.response.MessageResponse;
import com.balthazar.Messaging_System.message.entity.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public Message toEntity(MessageRequest request){
        return new Message(
                request.title(),
                request.description(),
                request.sendTo(),
                request.provider()
        );
    }

    public MessageResponse toResponse(Message message){
        return new MessageResponse(
                message.getTitle(),
                message.getDescription(),
                message.getSendTo(),
                message.getProvider()
        );
    }
}
