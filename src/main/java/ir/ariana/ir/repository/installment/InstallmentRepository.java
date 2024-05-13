package ir.ariana.ir.repository.installment;

import ir.ariana.ir.base.BaseRepository;
import ir.ariana.ir.enums.InstallmentStatus;
import ir.ariana.ir.model.Installment;
import ir.ariana.ir.model.Loan;
import ir.ariana.ir.model.Student;

import java.util.List;
import java.util.Optional;

public interface InstallmentRepository extends BaseRepository<Installment,Long> {
    List<Installment> findPaidInstallment(Student student, Loan loan, InstallmentStatus installmentStatus);
    List<Installment> findUnPaidInstallment(Student student, Loan loan, InstallmentStatus installmentStatus);
    Optional<Installment> findByStudentId(Long id,Student student);
    Double sumAllLoanAmountPerStudent(Student student);
}
