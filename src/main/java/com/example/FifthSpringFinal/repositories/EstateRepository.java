package com.example.FifthSpringFinal.repositories;

import com.example.FifthSpringFinal.dto.CustomUser;
import com.example.FifthSpringFinal.dto.EstateDto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EstateRepository extends CrudRepository<EstateDto, Integer> {

}
