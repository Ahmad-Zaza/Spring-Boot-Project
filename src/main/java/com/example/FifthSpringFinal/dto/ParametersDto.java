package com.example.FifthSpringFinal.dto;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "parameters_static")
public class ParametersDto {

    public ParametersDto() {
    }

    public ParametersDto(String key, int value) {
        this.key = key;
        this.value = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "key_parameter")
    private String key;

    @Column(nullable = false, name = "value_parameter")
    private int value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ParametersDto{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
