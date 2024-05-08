package h13_hibernateLifeCicle;

import h12_get_load.Student12;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave13 {
    public static void main(String[] args) {

        Student13 student1 = new Student13();   // Transient State - Hibernate won't start
        student1.setName("Mark");
        student1.setGrade(89);


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student12.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        session.save(student1); // Persistent State

        student1.setName("John");

//        session.clear();  //
//        session.evict(student1);    // Detached state => hibernate will not track the
//        changes will be rollback, initial ones will remain


        // to bring it to Persistent state
        session.update(student1);   // Detached State => will be changed to Detached from Persistent
        // OR
        session.merge(student1);   // Detached State => will be changed to Detached from Persistent

        student1.setName("Kim");

        session.delete(student1);   // Removed State


        tx.commit();
        session.close();
        sf.close();

    }
}
