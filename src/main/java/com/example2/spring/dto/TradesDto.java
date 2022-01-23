package com.example2.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

@Data
@Builder
@AllArgsConstructor

public class TradesDto {

    @Id
    @GeneratedValue

    private Integer id;
    private String name;
    private String city;
    private String place;
    private String period;

}
