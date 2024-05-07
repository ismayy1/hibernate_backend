package h10_idGeneration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {
    public static void main(String[] args) {

        Student10 student1 = new Student10();
//        student1.setId(1001); // bcs we set the 'strategy = GeneratedType.IDENTITY', we no longer need to set the id
        student1.setName("John");
        student1.setGrade(90);

        Student10 student2 = new Student10();
//        student2.setId(1002);
        student2.setName("Mark");
        student2.setGrade(99);

        Student10 student3 = new Student10();

        student3.setName("John");
        student3.setGrade(90);


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student10.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        session.save(student1);
        session.save(student2);
        session.save(student3);


        tx.commit();
        session.close();
        sf.close();

    }
}
