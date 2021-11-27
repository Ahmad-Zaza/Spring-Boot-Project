package com.example.FifthSpringFinal.dto;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "parameters")
public class ParametersDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int key;

    @Column(nullable = false)
    private double value;
}
