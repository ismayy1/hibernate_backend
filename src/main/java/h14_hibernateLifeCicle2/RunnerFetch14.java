package h14_hibernateLifeCicle2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch14 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee14.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        System.out.println("************* session.get() executed *************");
        Employee14 employee1 = session.get(Employee14.class, 1L);


        System.out.println("************* session.delete() executed *************");
        session.delete(employee1);


        tx.commit();
        session.close();
        sf.close();

    }
}
