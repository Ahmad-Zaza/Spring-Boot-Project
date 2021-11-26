package com.example.FifthSpringFinal.services;


import com.example.FifthSpringFinal.dto.EstateDto;
import com.example.FifthSpringFinal.repositories.EstateRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstateService implements IEstateService {

    EstateRepository estateRepository;

    public EstateService(EstateRepository estateRepository){
        this.estateRepository = estateRepository;
    }

    @Override
    public List<EstateDto> getEstates() {
        List<EstateDto> estates = new ArrayList<>();
        estateRepository.findAll().forEach(estates::add);
        return estates;
    }


    @Override
    public EstateDto getEstateById(int id) {
        return estateRepository.findById(id).get();
    }

    @Override
    public EstateDto insert(EstateDto estateDto) {
        return estateRepository.save(estateDto);
    }

    @Override
    public void updateEstate(int id, EstateDto estateDto) {
        EstateDto estateFromDb = estateRepository.findById(id).get();
        estateFromDb.setName(estateDto.getName());
        estateFromDb.setPrice(estateDto.getPrice());
        estateFromDb.setNumOfShares(estateDto.getNumOfShares());
        estateFromDb.setCustomUser(estateDto.getCustomUser());
        estateRepository.save(estateFromDb);
    }

    @Override
    public void deleteEstate(int estate_id) {
        estateRepository.deleteById(estate_id);
    }
}
