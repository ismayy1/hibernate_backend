package h4_bi_oneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "t_student04")
public class Student04 {

    @Id
    private int id;

    private String name;

    private int grade;

}
