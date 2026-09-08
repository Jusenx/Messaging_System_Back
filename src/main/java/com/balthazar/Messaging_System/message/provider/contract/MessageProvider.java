package com.balthazar.Messaging_System.message.provider.contract;


import com.balthazar.Messaging_System.message.entity.Message;

public interface MessageProvider {

    void send(Message message);

}
