package com.example.FifthSpringFinal.services;

import com.example.FifthSpringFinal.dto.ParametersDto;
import com.example.FifthSpringFinal.repositories.ParametersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.*;


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

    /*@CacheEvict(value="twenty-second-cache", key = "'StudentInCache'+#studentId",
            condition = "#isCacheable == null || !#isCacheable", beforeInvocation = true)
    @Cacheable(value="twenty-second-cache", key = "'StudentInCache'+#studentId",
            condition = "#isCacheable != null && #isCacheable")
    public Optional<Student> fetchStudent(String studentId, boolean isCacheable) throws InterruptedException {
        Thread.sleep(4000);
        return Arrays
                .asList(new Student("19VC21", "John", "Wayne", "11",
                                new Address("12A", "Bay Avenue", "SanFrancisco", "CA", "91234"), Major.MATHS),
                        new Student("19VC22", "Mary", "Jane", "11",
                                new Address("10A", "Cross Avenue", "SanFrancisco", "CA", "91238"), Major.CHEMISTRY),
                        new Student("19VC23", "Peter", "Parker", "11",
                                new Address("1A", "First Avenue", "SanFrancisco", "CA", "91934"), Major.PHYSICS))
                .stream().filter(t -> t.getId().equalsIgnoreCase(studentId)).findFirst();
    }*/

    @CacheEvict(value = "twenty-second-cache", key = "'StudentInCache'+#key",
            condition = "#isCacheable == null || !#isCacheable", beforeInvocation = true)
    @Cacheable(value = "twenty-second-cache", key = "'StudentInCache'+#key",
            condition = "#isCacheable != null && #isCacheable")
    public Optional<ParametersDto> fetchStudent(String key, boolean isCacheable) throws InterruptedException {
        Thread.sleep(4000);
        List<ParametersDto> list = new ArrayList<>();
        for (ParametersDto parametersDto : parametersRepository.findAll()) {
            list.add(parametersDto);
        }

        System.out.println("*******> " + list.toString());
        return list.stream().filter(p -> p.getKey().equalsIgnoreCase(key)).findFirst();


        /*return Arrays
                .asList(new ParametersDto("arrow_count", 20), new ParametersDto("profit_ratio", 800))
                .stream().filter(t -> t.getKey().equalsIgnoreCase(key)).findFirst();*/
    }

    boolean getContains(String key, List<ParametersDto> list) {
        for (ParametersDto parametersDto : list) {
            if (parametersDto.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }


}
