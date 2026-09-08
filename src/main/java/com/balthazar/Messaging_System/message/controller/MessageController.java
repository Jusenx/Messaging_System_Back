package com.balthazar.Messaging_System.message.controller;

import com.balthazar.Messaging_System.message.dto.request.MessageRequest;
import com.balthazar.Messaging_System.message.dto.response.MessageResponse;
import com.balthazar.Messaging_System.message.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/message")
@AllArgsConstructor
public class MessageController {

    private final MessageService service;

    @PostMapping
    public MessageResponse create(@RequestBody MessageRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public MessageResponse getById(@RequestParam UUID id){
        return service.getById(id);
    }

}
