package h7_bi_oneToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "t_student07")
public class Student07 {

    @Id
    private int id;

    @Column (name = "std_name", length = 50, nullable = false)
    private String name;

    private int grade;

    @OneToMany (mappedBy = "student", cascade = CascadeType.REMOVE, orphanRemoval = true) // there'll be no foreign key in Student, hence 3rd table won't be created
    // cascade = CascadeType.REMOVE => same thing as "orphanRemoval = true", the orphanRemoval is more strict
    private List<Book07> book07List = new ArrayList<>();

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
    public List<Book07> getBook07List() {
        return book07List;
    }
    public void setBook07List(List<Book07> book07List) {
        this.book07List = book07List;
    }
    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", book07List=" + book07List +
                '}';
    }
}
