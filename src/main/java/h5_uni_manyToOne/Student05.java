package h5_uni_manyToOne;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "t_student05")
public class Student05 {

    @Id
    private int id;

    @Column (name = "std_name", nullable = false)
    private String name;

    private int grade;

    private LocalDateTime createdOn;    // creation date time

    @ManyToOne
    @JoinColumn (name = "univ_id")
    private University05 university;

    @PrePersist     // to trigger the method just before we create instance form this class is persisted
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getGrade() {
        return grade;
    }
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
    public University05 getUniversity() {
        return university;
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
    public void setUniversity(University05 university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createdOn=" + createdOn +
                ", university=" + university +
                '}';
    }
}
