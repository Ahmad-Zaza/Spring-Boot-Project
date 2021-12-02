package com.example.FifthSpringFinal.web_socket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatEndpoints {

    @MessageMapping("/A")
    @SendTo("/sample/publish2")
    public String publicMessageA(String message) {
        return message;
    }

    @MessageMapping("/B")
    @SendTo("/sample/publish1")
    public String publicMessageB(String message) {
        return message;
    }
}
