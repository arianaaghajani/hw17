package ir.ariana.ir.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseEntity<ID extends Serializable> implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    protected ID id;
}
