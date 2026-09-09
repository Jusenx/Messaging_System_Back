package com.balthazar.Messaging_System.message.service;

import com.balthazar.Messaging_System.message.dto.mapper.MessageMapper;
import com.balthazar.Messaging_System.message.dto.request.MessageRequest;
import com.balthazar.Messaging_System.message.dto.response.MessageResponse;
import com.balthazar.Messaging_System.message.entity.Message;
import com.balthazar.Messaging_System.message.enums.StatusEnum;
import com.balthazar.Messaging_System.message.provider.factory.ProviderFactory;
import com.balthazar.Messaging_System.message.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class MessageService {

    private final MessageRepository repository;
    private final MessageMapper mapper;
    private final ProviderFactory factory;

    public MessageResponse create(MessageRequest request) {

        Message message = mapper.toEntity(request);
        message.setStatus(StatusEnum.PENDING);
        Message savedMessage = repository.save(message);
        factory.getProvider(savedMessage).send(savedMessage);
        return mapper.toResponse(savedMessage);

    }

    public MessageResponse getById(UUID id){
        Message message = repository.getById(id);
        return mapper.toResponse(message);
    }

}
