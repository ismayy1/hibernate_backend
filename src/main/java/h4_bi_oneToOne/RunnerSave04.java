package h4_bi_oneToOne;

import h3_uni_oneToOne.Dairy;
import h3_uni_oneToOne.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {


        Student04 student01 = new Student04();
        student01.setId(1001);
        student01.setName("Mikail");
        student01.setGrade(90);

        Student04 student02 = new Student04();
        student02.setId(1002);
        student02.setName("Tamara");
        student02.setGrade(95);

        Dairy04 dairy1 = new Dairy04();
        dairy1.setId(101);
        dairy1.setName("Mikail's dairy");
//        dairy1.setStudent(student01);

        Dairy04 dairy2 = new Dairy04();
        dairy2.setId(102);
        dairy2.setName("Tamara's dairy");
//        dairy2.setStudent(student02);

//        student01.setDairy(dairy1);   // since in Student class we used mappedBy, settings field will be done by Dairy side
//        student02.setDairy(dairy2);



        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student04.class)
                .addAnnotatedClass(Dairy04.class);

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
