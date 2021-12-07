package com.example.FifthSpringFinal.mq_utils.socket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greet(HelloMessage message) throws InterruptedException {
        return new Greeting(HtmlUtils.htmlEscape(message.getName()));
    }

    @GetMapping("/viewSocket")
    public String showIt(){
        return "socket_queue_messages";
    }
}