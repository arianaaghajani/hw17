package ir.ariana.ir.model;

import ir.ariana.ir.entity.BaseEntity;
import ir.ariana.ir.enums.InstallmentStatus;
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
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Installment extends BaseEntity<Long> {
    Integer installmentNumber;
    Double amount;
    LocalDate dueDate;
    LocalDate paymentDate;
    @Enumerated(EnumType.STRING)
    InstallmentStatus installmentStatus;

    @ManyToOne
    Student student;

    @ManyToOne
    Loan loan;

}
