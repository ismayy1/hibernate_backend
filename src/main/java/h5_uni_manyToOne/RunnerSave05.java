package h5_uni_manyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {
    public static void main(String[] args) {

        Student05 student1 = new Student05();
        student1.setId(1001);
        student1.setName("Sedat");
        student1.setGrade(80);

        Student05 student2 = new Student05();
        student2.setId(1002);
        student2.setName("Amena");
        student2.setGrade(90);


        Student05 student3 = new Student05();
        student3.setId(1003);
        student3.setName("Ismail");
        student3.setGrade(87);

        University05 university = new University05();
        university.setId(101);
        university.setName("TPE University");


        student1.setUniversity(university);
        student2.setUniversity(university);
        student3.setUniversity(university);

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student05.class).addAnnotatedClass(University05.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(university);

        tx.commit();
        session.close();
        sf.close();
    }
}
