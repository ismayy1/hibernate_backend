package h4_bi_oneToOne;

import h3_uni_oneToOne.Dairy;

import javax.persistence.*;

@Entity
@Table (name = "t_student04")
public class Student04 {

    @Id
    private int id;

    private String name;

    private int grade;

    @OneToOne(mappedBy = "student") // don't create column on this table
//    @JoinColumn
    private Dairy04 dairy;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public Dairy04 getDairy() {
        return dairy;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setDairy(Dairy04 dairy) {
        this.dairy = dairy;
    }

    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", dairy=" + dairy +
                '}';
    }
}
