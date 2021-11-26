package com.example.FifthSpringFinal.dao;

import com.example.FifthSpringFinal.dto.CustomUser;
import com.example.FifthSpringFinal.dto.CustomUserDto;
import com.example.FifthSpringFinal.dto.EstateDto;
import com.example.FifthSpringFinal.repositories.EstateRepository;
import com.example.FifthSpringFinal.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class EstateRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateEstate(){
    try {
        EstateDto estate =new EstateDto();
        estate.setName("estate 1");
        estate.setPrice(500);
        estate.setNumOfShares(3);
        estate.setCustomUser(userRepository.findByUsername("zaza98"));
    }catch (Exception e){
        throw  e;
    }
    }
}
