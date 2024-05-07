package h9_fetchType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "t_books09")
public class Books09 {

    @Id
    private int id;

    private String name;

    @ManyToOne (fetch = FetchType.LAZY) // by default it's eager loading
    @JoinColumn (name = "std_id")
    private Student09 student;

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
    public Student09 getStudent() {
        return student;
    }
    public void setStudent(Student09 student) {
        this.student = student;
    }
    @Override
    public String toString() {
        return "Books09{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", student=" + student +
                '}';
    }
}
