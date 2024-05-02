package h4_bi_oneToOne;

import javax.persistence.*;

@Entity
@Table (name = "t_dairy04")
public class Dairy04 {

    @Id
    private int id;

    private String name;

    @OneToOne
    @JoinColumn (name = "std_id")
    private Student04 student;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Student04 getStudent() {
        return student;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudent(Student04 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Dairy04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
