package com.practiceproject1.simpleapi.student;

import com.practiceproject1.simpleapi.laptop.Laptop;
import com.practiceproject1.simpleapi.laptop.LaptopRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final LaptopRepository laptopRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, LaptopRepository laptopRepository) {
        this.studentRepository = studentRepository;
        this.laptopRepository = laptopRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public Optional<Student> findByFirstName(String firstName){
        return studentRepository.findByFirstName(firstName);
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

//    public Optional<Student> getStudentByLaptop(UUID laptopId){
//        return studentRepository.findByLaptop(laptopId);
//    }
}
