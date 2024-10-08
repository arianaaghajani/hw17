package ir.ariana.ir.model;

import ir.ariana.ir.entity.BaseEntity;
import ir.ariana.ir.enums.BankType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class BankCard extends BaseEntity<Long> {
    public String numberCard;
    private String cvv2;
    private String expirationDate;

    @Enumerated(EnumType.STRING)
    private BankType bankType;

    @ManyToOne
    private Student student;


    public BankCard(String numberCard, String cvv2, String expirationDate,
                    BankType bankType, Student student) {
        this.numberCard = numberCard;
        this.cvv2 = cvv2;
        this.expirationDate = expirationDate;
        this.bankType = bankType;
        this.student = student;
    }
}
