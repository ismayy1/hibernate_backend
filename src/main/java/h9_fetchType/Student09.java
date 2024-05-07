package h9_fetchType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "t_student09")
public class Student09 {

    @Id
    private int id;

    @Column(name = "std_name", length = 50, nullable = false)
    private String name;

    private int grade;

    @OneToMany (mappedBy = "student")
    private List<Books09> books09List = new ArrayList<>();

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
    public List<Books09> getBooks09List() {
        return books09List;
    }
    public void setBooks09List(List<Books09> books09List) {
        this.books09List = books09List;
    }
    @Override
    public String toString() {
        return "Student09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", books09List=" + books09List +
                '}';
    }
}
