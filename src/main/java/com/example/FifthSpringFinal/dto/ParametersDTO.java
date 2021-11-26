package com.example.FifthSpringFinal.dto;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "parameters")
public class ParametersDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="num_of_shares", nullable = false)
    private int numOfShares;

    @Column(name="profit_ratio")
    private double profitRatio;
}
