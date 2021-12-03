package com.example.FifthSpringFinal;

import com.example.FifthSpringFinal.dto.ParametersDto;
import com.example.FifthSpringFinal.dto.mq.MessageDtoStatus;
import com.example.FifthSpringFinal.services.IParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FifthSpringFinalApplication implements CommandLineRunner {

    @Autowired
    private IParametersService parametersService;

    public static List<MessageDtoStatus> messages =new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(FifthSpringFinalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        int countParams = 0;
        countParams = parametersService.getCountRows();
        if(countParams == 0){
            System.out.println("Hello World! for first time!");
            parametersService.save(new ParametersDto(
                    "arrow_count", 20
            ));
            parametersService.save(new ParametersDto(
                    "profit_ratio", 800
            ));
        }
    }
}
