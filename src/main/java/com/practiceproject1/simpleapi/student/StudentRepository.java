package com.practiceproject1.simpleapi.student;

import com.practiceproject1.simpleapi.laptop.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    Optional<Student> findByFirstName(String firstName);
//    Optional<Student> findByLaptop(UUID laptop);
}
