package com.example.ksw12militaryapi;

import com.example.ksw12militaryapi.model.MndSaleDTO;
import com.example.ksw12militaryapi.model.MndSaleMasterDTO;
import com.example.ksw12militaryapi.service.MilitaryAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Ksw12MilitaryApiApplication {

    @Autowired
    static MilitaryAPIService militaryAPIService;

    public static void main(String[] args) {

        SpringApplication.run(Ksw12MilitaryApiApplication.class, args);

    }

}
