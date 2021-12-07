package com.example.FifthSpringFinal.repositories;

import com.example.FifthSpringFinal.dto.mq.MessageDto;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<MessageDto, Integer> {
}
