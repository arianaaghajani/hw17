package ir.ariana.ir.service.bankCard;

import ir.ariana.ir.model.BankCard;
import ir.ariana.ir.model.Student;
import ir.ariana.ir.service.base.BaseService;

public interface BankCardService extends BaseService<BankCard,Long> {
    boolean existByNumberCard(String numberCard);

    boolean existBankCardByNumberCardAndCvvAndExpirationDate(Student student, String numberCard,
                                                             String cvv, String expirationDate);

    boolean hasBankCardForStudent(Student student);

}
