package com.example.FifthSpringFinal.controller;


import com.example.FifthSpringFinal.dto.CustomUser;
import com.example.FifthSpringFinal.dto.EstateDto;
import com.example.FifthSpringFinal.repositories.EstateRepository;
import com.example.FifthSpringFinal.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.http.RequestEntity.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class EstateControllerTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EstateRepository estateRepository;

    @Autowired
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception{

    }

    @Test
    public void getAllEstates() throws Exception {
        CustomUser user = new CustomUser();
        user.setFirstName("ahmad");
        user.setLastName("zaza");
        user.setUsername("zaza98");
        user.setPassword("12345678");
        userRepository.save(user);
        EstateDto estate = new EstateDto();
        estate.setCustomUser(user);
        estate.setPrice(123);
        estate.setName("estate1");
        estate.setNumOfShares(3);
        estate.setSold(false);
        estateRepository.save(estate);
        //
        mvc.perform(MockMvcRequestBuilders.get("/api/estate")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void getEstateById() throws Exception{
        CustomUser user = new CustomUser();
        user.setFirstName("ahmad");
        user.setLastName("zaza");
        user.setUsername("zaza98");
        user.setPassword("12345678");
        userRepository.save(user);
        EstateDto estate = new EstateDto();
        estate.setCustomUser(user);
        estate.setPrice(123);
        estate.setName("estate1");
        estate.setNumOfShares(3);
        estate.setSold(false);
        estateRepository.save(estate);
        //
        mvc.perform(MockMvcRequestBuilders.get("/api/estate/{estate_id}",1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void addEstate() throws Exception{
        CustomUser user = new CustomUser();
        user.setFirstName("ahmad");
        user.setLastName("zaza");
        user.setUsername("zaza98");
        user.setPassword("12345678");
        userRepository.save(user);
        mvc.perform(MockMvcRequestBuilders.post("/api/estate?userId=1").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\" : \"estate1\",\n" +
                        "    \"price\" : 233\n" +
                        "}"))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void editEstate() throws Exception{
        CustomUser user = new CustomUser();
        user.setFirstName("ahmad");
        user.setLastName("zaza");
        user.setUsername("zaza98");
        user.setPassword("12345678");
        userRepository.save(user);
        EstateDto estate = new EstateDto();
        estate.setCustomUser(user);
        estate.setPrice(123);
        estate.setName("estate1");
        estate.setNumOfShares(3);
        estate.setSold(false);
        estateRepository.save(estate);
        //
        mvc.perform(MockMvcRequestBuilders.put("/api/estate/1/1").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\" : \"edit\"\n" +
                        "}"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void deleteEstate() throws Exception{
        CustomUser user = new CustomUser();
        user.setFirstName("ahmad");
        user.setLastName("zaza");
        user.setUsername("zaza98");
        user.setPassword("12345678");
        userRepository.save(user);
        EstateDto estate = new EstateDto();
        estate.setCustomUser(user);
        estate.setPrice(123);
        estate.setName("estate1");
        estate.setNumOfShares(3);
        estate.setSold(false);
        estateRepository.save(estate);
        //
        mvc.perform(MockMvcRequestBuilders.delete("/api/estate/1").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(print());

    }
    //comment



}
