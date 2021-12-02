package com.example.FifthSpringFinal.controllers;


import com.example.FifthSpringFinal.dto.CustomUser;
import com.example.FifthSpringFinal.dto.EstateDto;
import com.example.FifthSpringFinal.repositories.EstateRepository;
import com.example.FifthSpringFinal.services.IEstateService;
import com.example.FifthSpringFinal.services.IParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://10.0.2.2:8080"})
@RequestMapping("/api/estate")
public class EstateController {

    @Autowired
    private EstateRepository estateRepository;

    @Autowired
    private IEstateService estateService;

    @Autowired
    private IParametersService parametersService;

    @GetMapping
    public ResponseEntity<?> getAllEstates() {
        try {
            List<EstateDto> estates = estateService.getEstates();
            return new ResponseEntity<>(estates, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/{estate_id}"})
    public ResponseEntity<?> getEstate(@PathVariable Integer estate_id) {
        return new ResponseEntity<>(estateService.getEstateById(estate_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveEstate(@RequestBody EstateDto estate, @RequestParam int userId) {
        if(estate.getNumOfShares() == 0){
           estate.setNumOfShares(parametersService.getNumberOfShares());
        }
        CustomUser customUser = estateService.getUserById(userId);
        estate.setCustomUser(customUser);
        EstateDto estateDto = estateService.insert(estate);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("estate", "/api/estate/" + estateDto.getId());
        return new ResponseEntity<>(estateDto, httpHeaders, HttpStatus.CREATED);


        /*
            {
                "user_id": 1,
                "name": "123123123",
                "price": 22
            }
         */

    }

    @PutMapping({"/{user_id}/{estate_id}"})
    public ResponseEntity<?> updateEstate(@PathVariable("estate_id") Integer estate_id, @PathVariable("user_id") Integer userId, @RequestBody EstateDto estate) {
        CustomUser customUser = estateService.getUserById(userId);
        estate.setCustomUser(customUser);
        estateService.updateEstate(estate_id, estate);
        return new ResponseEntity<>(estateService.getEstateById(Math.toIntExact(estate_id)), HttpStatus.OK);
    }

    @DeleteMapping({"/{estate_id}"})
    public ResponseEntity<?> deleteTodo(@PathVariable("estate_id") Integer estate_id) {
        estateService.deleteEstate(estate_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping({"/buy/{user_id}/{estate_id}"})
    public  ResponseEntity<?> buyEstate(@PathVariable("estate_id") Integer estate_id, @PathVariable("user_id") Integer userId, @RequestBody EstateDto estate){
        if(estate.getSellPrice() == 0.0){
            System.out.println("you my Ooh: " + parametersService.getSellPrice(estate.getPrice()));
            estate.setSellPrice(parametersService.getSellPrice(estate.getPrice()));
        }

        if(estate.getNumOfShares() == 0){
            estate.setNumOfShares(parametersService.getNumberOfShares());
        }
        CustomUser customUser = estateService.getUserById(userId);
        estate.setCustomUser(customUser);
        estateService.buyEstate(estate_id, estate);
        return new ResponseEntity<>(estateService.getEstateById(Math.toIntExact(estate_id)), HttpStatus.OK);

        /*
        {
            "user_id": 1,
            "name": "123123123",
            "price": 22,
            "purchaser": "ZEDO"
         }

         OR:

         {
            "user_id": 1,
            "name": "123123123",
            "price": 22,
            "sellPrice": 84512,
            "purchaser": "ZEDO"
         }
        */


    }

}
