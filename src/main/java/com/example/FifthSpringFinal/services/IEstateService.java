package com.example.FifthSpringFinal.services;

import com.example.FifthSpringFinal.dto.CustomUser;
import com.example.FifthSpringFinal.dto.EstateDto;

import java.util.List;

public interface IEstateService {
    List<EstateDto> getEstates();

    EstateDto getEstateById(int id);

    EstateDto insert(EstateDto estateDto);

    void updateEstate(int id, EstateDto estateDto);

    void deleteEstate(int estate_id);

    CustomUser getUserById(int userId);

    void buyEstate(int estate_id, EstateDto estateDto);
}
