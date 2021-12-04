package com.example.FifthSpringFinal.dto;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

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

    @Column(name = "updated_at")
    @LastModifiedDate
    Date updatedAt;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @PrePersist
    private void onCreate() {
        this.createdAt = new Date(System.currentTimeMillis());
    }

    @PreUpdate
    private void onUpdate() {
        this.createdAt = new Date(System.currentTimeMillis());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
