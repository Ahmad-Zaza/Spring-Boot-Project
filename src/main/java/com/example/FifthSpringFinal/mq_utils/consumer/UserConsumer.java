package com.example.FifthSpringFinal.mq_utils.consumer;

import com.example.FifthSpringFinal.FifthSpringFinalApplication;
import com.example.FifthSpringFinal.dto.mq.MessageDtoStatus;
import com.example.FifthSpringFinal.mq_utils.config.MessageConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {
    @RabbitListener(queues = MessageConfig.QUEUE)
    public void viewMessages(MessageDtoStatus messageDtoStatus){
        FifthSpringFinalApplication.messages.add(messageDtoStatus);
        System.out.println("Message recieved from queue : " + messageDtoStatus.toString());
    }

}
