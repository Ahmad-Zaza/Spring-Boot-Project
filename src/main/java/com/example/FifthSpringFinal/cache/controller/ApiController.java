package com.example.FifthSpringFinal.cache.controller;

import com.example.FifthSpringFinal.dto.ParametersDto;
import com.example.FifthSpringFinal.services.ParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/parameter")
public class ApiController {

    @Autowired
    private ParametersService parametersService;

    @GetMapping
    public ResponseEntity<ParametersDto> fetchStudent(@RequestParam(name = "key") String studentId,
                                                      @RequestParam(name = "isCacheable") boolean isCacheable) throws InterruptedException {
        return new ResponseEntity<>(parametersService.fetchStudent(studentId, isCacheable).get(), HttpStatus.OK);
    }
}
