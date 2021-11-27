package com.example.FifthSpringFinal.controllers;


import com.example.FifthSpringFinal.dto.EstateDto;
import com.example.FifthSpringFinal.repositories.EstateRepository;
import com.example.FifthSpringFinal.services.EstateService;
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
   private EstateService estateService;

    @GetMapping
    public ResponseEntity<?> getAllEstates() {
        try {
            List<EstateDto> estates = estateService.getEstates();
            return new ResponseEntity<>(estates, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/{estate_id}"})
    public ResponseEntity<?> getEstate(@PathVariable Integer estate_id) {
        return new ResponseEntity<>(estateService.getEstateById(estate_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveEstate(@RequestBody EstateDto estate){
        EstateDto estateDto = estateService.insert(estate);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("estate", "/api/estate/" + estateDto.getId());
        return new ResponseEntity<>(estateDto,httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{estate_id}"})
    public ResponseEntity<?> updateEstate(@PathVariable("estate_id") Integer estate_id, @RequestBody EstateDto estate) {
        estateService.updateEstate(estate_id, estate);
        return new ResponseEntity<>(estateService.getEstateById(Math.toIntExact(estate_id)), HttpStatus.OK);
    }

    @DeleteMapping({"/{estate_id}"})
    public ResponseEntity<?> deleteTodo(@PathVariable("estate_id") Integer estate_id) {
        estateService.deleteEstate(estate_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
