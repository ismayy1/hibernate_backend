package h12_get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch12 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student12.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        System.out.println("======== Start Executing get() ========");
        Student12 student1 = session.get(Student12.class, 1L);
        System.out.println("======== End Executing get() ========");




        tx.commit();
        session.close();
        sf.close();

    }
}
