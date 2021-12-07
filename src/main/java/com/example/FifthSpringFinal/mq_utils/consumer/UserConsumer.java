package com.example.FifthSpringFinal.mq_utils.consumer;

import com.example.FifthSpringFinal.FifthSpringFinalApplication;
import com.example.FifthSpringFinal.dto.mq.MessageDtoStatus;
import com.example.FifthSpringFinal.mq_utils.config.MessageConfig;
import com.example.FifthSpringFinal.services.IMessageDtoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserConsumer {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private IMessageDtoService messageDtoService;


    @RabbitListener(queues = MessageConfig.QUEUE)
    public void viewMessages(MessageDtoStatus messageDtoStatus){
        FifthSpringFinalApplication.messages.add(messageDtoStatus);
        sendToSocket(messageDtoStatus);
        System.out.println("Message recieved from queue : " + messageDtoStatus.toString());
    }

    public void sendToSocket(MessageDtoStatus messageDtoStatus) {
        System.out.println(messageDtoStatus.toString());
        messageDtoService.save(messageDtoStatus.getMessageDto());
        Map<String, String> map = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        map.put("date", messageDtoStatus.getMessageDto().getDate());
        map.put("email", messageDtoStatus.getMessageDto().getEmail());
        map.put("content", messageDtoStatus.getMessageDto().getContent());

        map2.put("message", map.toString());


        this.simpMessagingTemplate.convertAndSend("/topic/greetings", map2);
    }

}
