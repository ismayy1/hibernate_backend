package h11_cacheLevels;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch11 {
    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student11.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        System.out.println("======= First get Method =======");
        Student11 student1 = session.get(Student11.class, 1L);
        System.out.println("student1 = " + student1);

        System.out.println("======= Second get Method =======");
        Student11 student2 = session.get(Student11.class, 1L);  // it's just received from the first query
        System.out.println("student2 = " + student2);



        tx.commit();
        session.close();    // first session is closed

        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();


        System.out.println("======= Third get Method in second session =======");
        Student11 student3 = session2.get(Student11.class, 1L);
        System.out.println("student3 = " + student3);

        tx2.commit();
        session2.close();


        sf.close();


    }
}
