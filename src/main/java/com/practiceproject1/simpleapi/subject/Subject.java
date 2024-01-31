package com.practiceproject1.simpleapi.subject;

import com.practiceproject1.simpleapi.student.Student;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "subject")
@Table(name = "subject")
@Data
@NoArgsConstructor
public class Subject {
    @Id@GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "subject_name")
    @NonNull
    private String subjectName;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "subject_student",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    public Subject(UUID id, String subjectName) {
        this.id = id;
        this.subjectName = subjectName;
        this.students = new ArrayList<>();
    }
}
