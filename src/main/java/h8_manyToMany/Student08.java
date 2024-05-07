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

    @ManyToMany
//    @JoinTable (
//            name = "student08_book08",
//            joinColumns = {@JoinColumn (name = "std_id")},
//            inverseJoinColumns = {@JoinColumn (name = "book_id")}
//    )
    private List<Book08> book08List = new ArrayList<>();

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
    public List<Book08> getBook08List() {
        return book08List;
    }
    public void setBook08List(List<Book08> book08List) {
        this.book08List = book08List;
    }

    @Override
    public String toString() {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", book08List=" + book08List +
                '}';
    }
}
