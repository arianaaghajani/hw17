package ir.ariana.ir.service.loan;

import ir.ariana.ir.enums.Grade;
import ir.ariana.ir.enums.LoanType;
import ir.ariana.ir.model.Loan;
import ir.ariana.ir.model.Student;
import ir.ariana.ir.service.base.BaseService;

import java.time.LocalDate;

public interface LoanService extends BaseService<Loan,Long>{
    boolean existOneLoanPaymentPerSemester(Student studentEntity, Integer semesterNumber, Grade grade,
                                           LoanType loanType);
    boolean exist(Student student,Grade grade);
    LocalDate maxRecordDate(Student student);
    boolean existWifeHousingLoan(Student student,Grade grade);
}
