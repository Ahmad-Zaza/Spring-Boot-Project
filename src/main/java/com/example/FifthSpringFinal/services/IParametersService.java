package com.example.FifthSpringFinal.services;

import com.example.FifthSpringFinal.dto.ParametersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;

public interface IParametersService {
    int getNumberOfShares();

    double getSellPrice(double estatePrice);

    int getCountRows();

    void save(ParametersDto parametersDto);
}
