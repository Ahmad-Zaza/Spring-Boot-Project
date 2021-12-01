package com.example.FifthSpringFinal.services;

import com.example.FifthSpringFinal.dto.ParametersDto;
import com.example.FifthSpringFinal.repositories.ParametersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ParametersService implements IParametersService {

    @Autowired
    private ParametersRepository parametersRepository;


    @Override
    public int getNumberOfShares() {

        Iterable<ParametersDto> parametersDtoList = new ArrayList<>();
        int numberOfShares = 0;
        parametersDtoList = parametersRepository.findAll();
        for (ParametersDto parametersDto : parametersDtoList) {
            if (parametersDto.getKey().equals("arrow_count")) {
                numberOfShares = parametersDto.getValue();
            }
        }
        return numberOfShares;
        /*System.out.println("--------->>>>> " + parametersRepository.getNumberOfShares().toString());
        return parametersRepository.getNumberOfShares().getValue();*/
    }

    @Override
    public double getSellPrice(double estatePrice) {
        Iterable<ParametersDto> parametersDtoList = new ArrayList<>();
        double sellPrice = 0;
        parametersDtoList = parametersRepository.findAll();
        for (ParametersDto parametersDto : parametersDtoList) {
            if (parametersDto.getKey().equals("profit_ratio")) {
                sellPrice = parametersDto.getValue();
            }
        }
        return sellPrice * estatePrice;
    }


    @Override
    public int getCountRows() {
        Iterable<ParametersDto> parametersDtoList = new ArrayList<>();
        int counter = 0;
        parametersDtoList = parametersRepository.findAll();
        for (ParametersDto parametersDto : parametersDtoList) {
            counter++;
        }

        return counter;
    }

    @Override
    public void save(ParametersDto parametersDto) {
        parametersRepository.save(parametersDto);
    }
}
