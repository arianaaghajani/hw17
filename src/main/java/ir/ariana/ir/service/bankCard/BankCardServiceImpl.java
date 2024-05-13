package ir.ariana.ir.service.bankCard;

import ir.ariana.ir.model.BankCard;
import ir.ariana.ir.model.Student;
import ir.ariana.ir.repository.bankCard.BankCardRepository;
import ir.ariana.ir.service.base.BaseServiceImpl;
import org.hibernate.SessionFactory;

public class BankCardServiceImpl extends BaseServiceImpl<BankCard, Long, BankCardRepository>
        implements BankCardService {
    public BankCardServiceImpl(BankCardRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public boolean existByNumberCard(String numberCard) {
        return repository.existByNumberCard(numberCard);
    }

    @Override
    public boolean existBankCardByNumberCardAndCvvAndExpirationDate(Student student, String numberCard, String cvv,
                                                                    String expirationDate) {
        return repository.existBankCardByNumberCardAndCvvAndExpirationDate(student,numberCard,cvv,expirationDate);
    }

    @Override
    public boolean hasBankCardForStudent(Student student) {
        return repository.hasBankCardForStudent(student);
    }
}
