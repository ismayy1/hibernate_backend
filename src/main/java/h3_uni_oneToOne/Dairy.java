package h3_uni_oneToOne;

import javax.persistence.*;

@Entity
@Table (name = "t_dairy")
public class Dairy {

    @Id
    private int id;

    private String name;

    @OneToOne
    @JoinColumn (name = "std_id", unique = true)   // id of joined table will be named as std_id
    private Student03 student03;

    // getter-setter
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Student03 getStudent03() {
        return student03;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStudent03(Student03 student03) {
        this.student03 = student03;
    }

    @Override
    public String toString() {
        return "Dairy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student03=" + student03 +
                '}';
    }
}
