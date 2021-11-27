package com.example.FifthSpringFinal.controllers;

import com.example.FifthSpringFinal.dto.CustomUser;
import com.example.FifthSpringFinal.dto.EstateDto;
import com.example.FifthSpringFinal.repositories.EstateRepository;
import com.example.FifthSpringFinal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://10.0.2.2:8080"})
public class TestController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EstateRepository estateRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String getEmployees() {
        return "Welcome!";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public CustomUser createUser(){
            CustomUser user = new CustomUser();
            user.setFirstName("ahmad");
            user.setLastName("zaza");
            user.setUsername("zaza98");
            user.setPassword(passwordEncoder.encode("12345678"));
            userRepository.save(user);
            EstateDto estate = new EstateDto();
            estate.setCustomUser(user);
            estate.setNumOfShares(2);
            estate.setPrice(100);
            estate.setName("estate one");
            estateRepository.save(estate);
            return user;
    }
}
