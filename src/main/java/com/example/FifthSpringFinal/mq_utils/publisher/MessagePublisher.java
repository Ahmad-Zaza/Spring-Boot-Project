package com.example.FifthSpringFinal.mq_utils.publisher;

import com.example.FifthSpringFinal.dto.mq.MessageDto;
import com.example.FifthSpringFinal.dto.mq.MessageDtoStatus;
import com.example.FifthSpringFinal.mq_utils.config.MessageConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/message")
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping
    public String sendMessage(@RequestBody MessageDto messageDto){
        MessageDtoStatus messageDtoStatus = new MessageDtoStatus();
        messageDtoStatus.setMessageDto(messageDto);
        messageDtoStatus.setStatus("PROCESS");
        messageDtoStatus.setMessage("message sent successfully from : ");
        template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, messageDtoStatus);

        return  "Success !!";

    }
}
