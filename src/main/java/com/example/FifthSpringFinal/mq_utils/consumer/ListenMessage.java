package com.example.FifthSpringFinal.mq_utils.consumer;

import com.example.FifthSpringFinal.FifthSpringFinalApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListenMessage {

    @GetMapping("/view_messages")
    public static String viewMessages(Model model){
        model.addAttribute("messages", FifthSpringFinalApplication.messages);
        System.out.println("Message recieved from view : " + FifthSpringFinalApplication.messages);

        return "queue_messages";
    }
}
