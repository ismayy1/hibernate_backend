package h5_uni_manyToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "t_university")
public class University05 {

    @Id
    private int id;

    @Column (name = "univ_name", nullable = false, unique = true)
    private String name;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "University05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
