package com.example.FifthSpringFinal.services;

import com.example.FifthSpringFinal.dto.mq.MessageDto;
import com.example.FifthSpringFinal.dto.mq.MessageDtoStatus;
import com.example.FifthSpringFinal.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageDtoService implements  IMessageDtoService{

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void save(MessageDto messageDto) {
        messageRepository.save(messageDto);
    }
}
