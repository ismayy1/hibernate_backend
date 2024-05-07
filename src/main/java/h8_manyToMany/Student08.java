package h8_manyToMany;

import h7_bi_oneToMany.Book07;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "t_student08")
public class Student08 {

    @Id
    private int id;

    @Column(name = "std_name", length = 50, nullable = false)
    private String name;

    private int grade;


    private List<Book07> book07List = new ArrayList<>();

}
