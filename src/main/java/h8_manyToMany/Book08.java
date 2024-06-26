package h8_manyToMany;

import h7_bi_oneToMany.Student07;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "t_book08")
public class Book08 {

    @Id
    private int id;

    private String name;

    @ManyToMany (mappedBy = "book08List")   // there will not be new table for book_student
    private List<Student08> student08List = new ArrayList<>();

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
    public List<Student08> getStudent08List() {
        return student08List;
    }
    public void setStudent08List(List<Student08> student08List) {
        this.student08List = student08List;
    }
    @Override
    public String toString() {
        return "Book08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
