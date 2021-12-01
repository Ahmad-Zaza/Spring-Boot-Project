package com.example.FifthSpringFinal.repositories;

import com.example.FifthSpringFinal.dto.ParametersDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ParametersRepository extends CrudRepository<ParametersDto, Integer> {

    /*@Query(value = "SELECT * from parameters_static where key_parameter = \"arrow_count\";", nativeQuery = true)
    ParametersDto getNumberOfShares();*/
}
