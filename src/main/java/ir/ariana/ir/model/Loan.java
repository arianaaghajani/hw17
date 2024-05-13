package ir.ariana.ir.model;

import ir.ariana.ir.entity.BaseEntity;
import ir.ariana.ir.enums.LoanType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Loan extends BaseEntity<Long> {
    @Enumerated(EnumType.STRING)
    LoanType loanType;
    LocalDate loanDate;
    Double amount;
    @ManyToOne
    Student student;
    @ManyToOne
    Semester semester;

    public Loan(Long aLong) {
        super(aLong);
    }
}
