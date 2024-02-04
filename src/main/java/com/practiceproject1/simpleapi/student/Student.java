package com.practiceproject1.simpleapi.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.practiceproject1.simpleapi.laptop.Laptop;
import com.practiceproject1.simpleapi.subject.Subject;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "student")
@Table(name = "student")
public class Student {
    @Id@GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "first_name")
    @NotBlank(message = "firstname cannot be blank.")
    private String firstName;
    @Column(name = "last_name")
    @NotBlank(message = "lastname cannot be blank.")
    private String lastName;

    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
    private List<Laptop> laptop;
    @JsonIgnore
    @ManyToMany(mappedBy = "students", cascade = CascadeType.PERSIST)
    private List<Subject> subjects;

    public Student() {
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.laptop = new ArrayList<>();
        this.subjects = new ArrayList<>();
    }
}
