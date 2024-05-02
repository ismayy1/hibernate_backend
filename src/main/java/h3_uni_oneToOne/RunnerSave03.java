package h3_uni_oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {

        Student03 student01 = new Student03();
        student01.setId(1001);
        student01.setName("Mikail");
        student01.setGrade(90);

        Student03 student02 = new Student03();
        student02.setId(1002);
        student02.setName("Tamara");
        student02.setGrade(95);

        Dairy dairy1 = new Dairy();
        dairy1.setId(101);
        dairy1.setName("Mikail's dairy");
        dairy1.setStudent03(student01);

        Dairy dairy2 = new Dairy();
        dairy2.setId(102);
        dairy2.setName("Tamara's dairy");
        dairy2.setStudent03(student02);

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student03.class)
                .addAnnotatedClass(Dairy.class);

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student01);
        session.save(student02);

        session.save(dairy1);
        session.save(dairy2);

        tx.commit();
        session.close();
        sf.close();

    }
}
