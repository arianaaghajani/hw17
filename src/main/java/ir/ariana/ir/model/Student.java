package ir.ariana.ir.model;

import ir.ariana.ir.entity.BaseEntity;
import ir.ariana.ir.enums.Grade;
import ir.ariana.ir.enums.LoanType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student extends BaseEntity<Long> {
    String firstName;
    String lastName;
    String fatherName;
    String motherName;
    Integer nationalIdNumber;
    String nationalCode;
    LocalDate birthDate;
    String studentNumber;

    @ManyToOne
    University university;
    boolean married;
    boolean dormitory;
    Integer enteringYear;
    String username;
    String password;

    @Enumerated(EnumType.STRING)
    Grade grade;

    @Enumerated(EnumType.STRING)
    LoanType loan;

    @OneToMany(mappedBy = "student")
    List<Loan> loanList;

    @OneToMany(mappedBy = "student")
    List<BankCard> bankCardList;

    @OneToMany(mappedBy = "student")
    List<Semester>semesterList;

    @OneToMany(mappedBy = "student")
    List<Installment>installmentList;


}
