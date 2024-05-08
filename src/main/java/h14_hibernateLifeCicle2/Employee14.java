package h14_hibernateLifeCicle2;

import javax.persistence.*;

@Entity
@Table (name = "t_employee5")
public class Employee14 {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double salary;

    @PrePersist // will be executed just before
    public void onPrePersist () {
        System.out.println("============ onPrePersist() executed ============");
    }

    @PostPersist
    public void onPostPersist () {
        System.out.println("============ onPostPersist() executed ============");
    }

    @PostLoad
    public void onPostLoad () {
        System.out.println("============ onPostLoad() executed ============");
    }

    @PreRemove
    public void onPreRemove () {
        System.out.println("============ onPreRemove() executed ============");
    }

    @PostRemove
    public void onPostRemove () {
        System.out.println("============ onPostRemove() executed ============");
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee14{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
