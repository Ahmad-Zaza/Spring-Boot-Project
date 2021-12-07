package com.example.FifthSpringFinal.services;

import com.example.FifthSpringFinal.dto.ParametersDto;
import com.example.FifthSpringFinal.dto.mq.MessageDto;
import com.example.FifthSpringFinal.dto.mq.MessageDtoStatus;

public interface IMessageDtoService {
    void save(MessageDto messageDto);
}
