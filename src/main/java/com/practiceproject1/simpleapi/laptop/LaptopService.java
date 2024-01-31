package com.practiceproject1.simpleapi.laptop;

import com.practiceproject1.simpleapi.student.Student;
import com.practiceproject1.simpleapi.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class LaptopService {
    private final LaptopRepository laptopRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public LaptopService(LaptopRepository laptopRepository, StudentRepository studentRepository) {
        this.laptopRepository = laptopRepository;
        this.studentRepository = studentRepository;
    }

    public List<Laptop> getAllLaptops(){
        return laptopRepository.findAll();
    }
    public Laptop createLaptop(UUID studentId, Laptop laptop){
        Student student = studentRepository.findById(studentId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"no such student"));
        laptop.setStudent(student);
        List<Laptop> laptops = student.getLaptop();
        laptops.add(laptop);
        studentRepository.save(student);
        return laptop;
    }
}
