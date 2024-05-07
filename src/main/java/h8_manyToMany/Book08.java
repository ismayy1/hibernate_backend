package h8_manyToMany;

import h7_bi_oneToMany.Student07;

import javax.persistence.*;

@Entity
@Table (name = "t_book08")
public class Book08 {

    @Id
    private int id;

    private String name;


    private Student07 student;

    public int getId() {
        return id;
    }

}
