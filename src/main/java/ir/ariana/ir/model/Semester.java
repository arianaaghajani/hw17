package ir.ariana.ir.model;

import ir.ariana.ir.entity.BaseEntity;
import ir.ariana.ir.enums.Grade;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Semester extends BaseEntity<Long> {
    Integer semesterNumber;
    LocalDate entriesYear;

    @ManyToOne
    Student student;

    @ManyToOne
    University university;

    @Enumerated(EnumType.STRING)
    Grade grade;

    @OneToMany(mappedBy = "semester")
    List<Loan> loan;

    public Semester(int semesterNumber, LocalDate entriesYear, Student student,
                    University university, Grade grade) {
        this.semesterNumber=semesterNumber;
        this.university=university;
        this.grade=grade;
        this.entriesYear=entriesYear;
        this.student=student;
    }
}
