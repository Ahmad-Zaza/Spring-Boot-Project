package com.example.FifthSpringFinal.services;


import com.example.FifthSpringFinal.dto.CustomUser;
import com.example.FifthSpringFinal.dto.EstateDto;
import com.example.FifthSpringFinal.repositories.EstateRepository;
import com.example.FifthSpringFinal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstateService implements IEstateService {

    @Autowired
    EstateRepository estateRepository;

    @Autowired
    UserRepository userRepository;

    public EstateService(EstateRepository estateRepository) {
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
        estateDto.setWhoAdd(estateDto.getCustomUser().getFirstName() + " " + estateDto.getCustomUser().getLastName());
        return estateRepository.save(estateDto);
    }

    @Override
    public void updateEstate(int id, EstateDto estateDto) {
        EstateDto estateFromDb = estateRepository.findById(id).get();
        estateFromDb.setName(estateDto.getName());
        estateFromDb.setPrice(estateDto.getPrice());
        estateFromDb.setNumOfShares(estateDto.getNumOfShares());
        estateFromDb.setCustomUser(estateDto.getCustomUser());
        estateFromDb.setWhoEdit(estateDto.getCustomUser().getFirstName() + " " + estateDto.getCustomUser().getLastName());

        estateRepository.save(estateFromDb);
    }

    @Override
    public void deleteEstate(int estate_id) {
        estateRepository.deleteById(estate_id);
    }

    @Override
    public CustomUser getUserById(int userId) {
        System.out.println("=========== " + userRepository.findById(userId).get().toString());
        return userRepository.findById(userId).get();
    }

    @Override
    public void buyEstate(int estate_id, EstateDto estateDto) {
        EstateDto estateFromDb = estateRepository.findById(estate_id).get();
        estateFromDb.setName(estateDto.getName());
        estateFromDb.setPrice(estateDto.getPrice());
        estateFromDb.setNumOfShares(estateDto.getNumOfShares());
        estateFromDb.setCustomUser(estateDto.getCustomUser());
        estateFromDb.setPurchaser(estateDto.getPurchaser());
        estateFromDb.setSellPrice(estateDto.getSellPrice());
        estateFromDb.setSold(true);

        System.out.println("ooooooh " + estateDto.toString());

        estateRepository.save(estateFromDb);
    }


}
