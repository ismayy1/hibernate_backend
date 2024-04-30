package h1_annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {

        Student01 student01 = new Student01();
        student01.setId(1001);
        student01.setName("Mikail");
        student01.setGrade(90);

        Student01 student02 = new Student01();
        student02.setId(1002);
        student02.setName("Yunus");
        student02.setGrade(98);

        Student01 student03 = new Student01();
        student03.setId(1003);
        student03.setName("Ismail");
        student03.setGrade(86);

        // provide information about the config file and entity object

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        // save/insert the data into database
        session.save(student01);    // INSERT INTO t_student01 values (1001, 'Mikail', 90)
        session.save(student02);
        session.save(student03);

        transaction.commit();   // if not committed changes/updates will not be updated in DB
        session.close();
        sf.close();

    }
}
