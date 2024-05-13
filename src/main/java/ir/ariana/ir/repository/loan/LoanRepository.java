package ir.ariana.ir.repository.loan;

import ir.ariana.ir.base.BaseRepository;
import ir.ariana.ir.enums.Grade;
import ir.ariana.ir.enums.LoanType;
import ir.ariana.ir.model.Loan;
import ir.ariana.ir.model.Student;

import java.time.LocalDate;

public interface LoanRepository extends BaseRepository<Loan,Long> {
    boolean exist(Student student,Grade grade);
    boolean existWifeTakeHousingLoan(Student student, Grade grade);
    boolean existOneLoanPaymentPerSemester(Student student,Integer SemesterNumber, Grade grade, LoanType loanType);
    LocalDate maxRecordDate(Student student);
}
