package h6_uni_oneToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "t_student06")
public class Student06 {

    @Id
    private int id;

    @Column (name = "std_name", nullable = false)
    private String name;

    private int grade;

    @OneToMany
    @JoinColumn (name = "std_id")   // in OneToMany relation, this column will be created in Many side
    /*
        - if you don't add join column, since it can't add many foreign keys
        to one cell, by default it'll create third table to join these two tables.
        - @JoinColumn will add new column to the Many side to store foreign keys of
        One side. In this way, the third table won't be created.
     */
    private List<Book06> bookList = new ArrayList<>();

    //getter-setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book06> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book06> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
