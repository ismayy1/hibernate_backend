package h1_annotation;


import javax.persistence.*;

@Entity // table will be created from this class
@Table (name = "t_student01")  // to customize the table name
public class Student01 {    // student01 -> default table name

    @Id // column used after will be the primary_key
//    @Column (name = "std_id") // to customize the name of the column
    private int id; // default column name is: id

    @Column (name = "std_name", length = 50, nullable = false, unique = false)
    private String name;    // default name of the column

    @Transient  //column for this field will not be created, ignored
    private int grade;

    //if there are some large objects
//    @Lob
//    private byte[] image

    // getters - setters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getGrade() {
        return grade;
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

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}

