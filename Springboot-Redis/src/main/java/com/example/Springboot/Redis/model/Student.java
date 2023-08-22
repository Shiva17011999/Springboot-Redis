package com.example.Springboot.Redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {



    private Integer stdId;
    private String stdName;
    private Double stdFee;

}
