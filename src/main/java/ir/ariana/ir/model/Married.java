package ir.ariana.ir.model;

import ir.ariana.ir.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Married extends BaseEntity<Long> {
    String address;
    String rentalNumber;

    @ManyToOne
    Student student;

    @ManyToOne
    Student wife;

    @OneToOne
    Loan loan;

    public Married(Loan loan){
        this.loan=loan;
    }
}
