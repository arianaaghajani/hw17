package ir.ariana.ir.repository.bankCard;

import ir.ariana.ir.base.BaseRepository;
import ir.ariana.ir.model.BankCard;
import ir.ariana.ir.model.Student;

public interface BankCardRepository extends BaseRepository<BankCard, Long> {

    boolean existByNumberCard(String numberCard);

    boolean existBankCardByNumberCardAndCvvAndExpirationDate(Student student, String numberCard,
                                                             String cvv, String expirationDate);

    boolean hasBankCardForStudent(Student student);
}
