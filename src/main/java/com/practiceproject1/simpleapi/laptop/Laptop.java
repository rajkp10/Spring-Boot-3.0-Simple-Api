package com.practiceproject1.simpleapi.laptop;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.practiceproject1.simpleapi.student.Student;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Entity(name = "laptop")
@Table(name = "laptop")
@Data
@NoArgsConstructor
public class Laptop {
    @Id@GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "name")
    @NonNull
    private String laptopName;
    @ManyToOne
    @JoinColumn(name = "student_id" ,referencedColumnName = "id")
    private Student student;

    public Laptop(String laptopName) {
        this.laptopName=laptopName;
    }
}
