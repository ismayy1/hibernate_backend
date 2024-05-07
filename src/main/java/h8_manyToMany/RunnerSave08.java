package h8_manyToMany;

import h7_bi_oneToMany.Book07;
import h7_bi_oneToMany.Student07;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave08 {
    public static void main(String[] args) {

        //student obj
        Student08 student1 = new Student08();
        student1.setId(1001);
        student1.setName("John Coffee");
        student1.setGrade(10);

        Student08 student2 = new Student08();
        student2.setId(1002);
        student2.setName("James Bond");
        student2.setGrade(11);

        Student08 student3 = new Student08();
        student3.setId(1003);
        student3.setName("Tony Stark");
        student3.setGrade(9);

        //book obj
        Book08 book1 = new Book08();
        book1.setId(101);
        book1.setName("John's Art Book");

        Book08 book2 = new Book08();
        book2.setId(102);
        book2.setName("John's Math Book");

        Book08 book3 = new Book08();
        book3.setId(103);
        book3.setName("James's Java Book");

        Book08 book4 = new Book08();
        book4.setId(104);
        book4.setName("James's Hibernate Book");

        Book08 book5 = new Book08();
        book5.setId(105);
        book5.setName("Tony's JS Book");

        // set book for students
        List<Book08> book08List = new ArrayList<>();
        book08List.add(book1);
        book08List.add(book2);
        student1.setBook08List(book08List);

        List<Book08> book08List2 = new ArrayList<>();
        book08List2.add(book2);
        book08List2.add(book3);
        book08List2.add(book1);
        student2.setBook08List(book08List2);

        // set student for books
        List<Student08> student08List = new ArrayList<>();
        student08List.add(student2);
        book5.setStudent08List(student08List);


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student08.class).addAnnotatedClass(Book08.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);


        tx.commit();
        session.close();
        sf.close();

    }
}
