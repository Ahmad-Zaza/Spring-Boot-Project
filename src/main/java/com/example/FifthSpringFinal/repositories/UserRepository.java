package com.example.FifthSpringFinal.repositories;
import com.example.FifthSpringFinal.dto.CustomUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<CustomUser, Integer> {
    CustomUser findByUsername(String username);
}