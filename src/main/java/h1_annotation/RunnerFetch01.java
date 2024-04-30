package h1_annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch01 {
    public static void main(String[] args) {

        // provide information about the config file and entity object
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        /*
            To fetch the data from DB: there are 3 different ways:
                1. .get()
                2. SQL
                3. HQL
         */

        // .get() /////////////////////
        Student01 student01 = session.get(Student01.class, 1001);
        System.out.println("student01 = " + student01);


        transaction.commit();   // if not committed changes/updates will not be updated in DB
        session.close();
        sf.close();

    }
}
