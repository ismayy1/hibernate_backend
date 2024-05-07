package h10_idGeneration;

import javax.persistence.*;

@Entity
@Table (name = "t_student10")
public class Student10 {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int grade;

    public int getId() {
        return id;
    }

    // hence we set the 'strategy = GeneratedType.IDENTITY', we no longer need this set method for id
//    public void setId(int id) {
//        this.id = id;
//    }
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
    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
