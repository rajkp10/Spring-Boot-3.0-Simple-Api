package com.practiceproject1.simpleapi;

import com.practiceproject1.simpleapi.laptop.Laptop;
import com.practiceproject1.simpleapi.laptop.LaptopRepository;
import com.practiceproject1.simpleapi.student.Student;
import com.practiceproject1.simpleapi.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(StudentRepository studentRepositoty, LaptopRepository laptopRepository){
        return args -> {

        };
    }
}

