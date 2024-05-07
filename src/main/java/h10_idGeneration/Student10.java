package h10_idGeneration;

import javax.persistence.*;

@Entity
@Table (name = "t_student10")
public class Student10 {

    @Id
//    @GeneratedValue (strategy = GenerationType.SEQUENCE) // MySQL
    @GeneratedValue (generator = "sequence", strategy = GenerationType.SEQUENCE) // PostgreSQL
    @SequenceGenerator(
            name = "sequence",  // should be the same as the name of generator in GeneratedValue property above
            sequenceName = "student_sequence",  // name which will be used in DB
            initialValue = 1000,    // starting number of id
            allocationSize = 10 // default value is 50
    )
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
