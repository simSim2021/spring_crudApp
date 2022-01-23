package com.example2.spring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "trade_fairs")
@Data
@NoArgsConstructor
public class Trades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotEmpty(message = "Name is required")
    private String name;

    @Column
    @NotEmpty(message = "City is required")
    private String city;

    @Column
    @NotEmpty(message = "Place is required")
    private String place;

    @Column
    @NotEmpty(message = "Period is required")
    private String period;


}
