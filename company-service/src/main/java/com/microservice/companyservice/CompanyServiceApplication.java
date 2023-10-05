package com.microservice.companyservice;

import com.microservice.companyservice.dao.CompanyRepository;
import com.microservice.companyservice.entities.Company;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CompanyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyServiceApplication.class, args);
    }
@Bean //all function above a bean annotation should run on application boot
    CommandLineRunner start(CompanyRepository companyRepository){
        return args -> {
            Stream.of("A","B","C").forEach(cn->{
                companyRepository.save(new Company(null,cn,100+Math.random()*900));
            });
            companyRepository.findAll().forEach(System.out::println);
        };
    }
}
