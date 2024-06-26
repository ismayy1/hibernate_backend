package h2_embeddable;

import javax.persistence.*;

@Entity
@Table (name = "t_student02")
public class Student02 {

    @Id
    private int id;

    @Column (name = "std_name", length = 50, nullable = false)
    private String name;

    private int grade;

    @Embedded   // optional, can be added for readability
    private Address address;

    // getter-setter
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getGrade() {
        return grade;
    }
    public Address getAddress() {
        return address;
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
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
