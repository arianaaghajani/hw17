package ir.ariana.ir.model;

import ir.ariana.ir.entity.BaseEntity;
import ir.ariana.ir.enums.UniversityType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class University extends BaseEntity<Long> {
    @OneToMany(mappedBy = "university")
    List<Student> studentList;
    @OneToMany(mappedBy = "university")
    List<Semester> semesters;
    private String city;
    private String universityName;
    @Enumerated(EnumType.STRING)
    private UniversityType universityType;

    public University(Long id){
        super(id);
    }

}
