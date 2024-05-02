package h3_uni_oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {


        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student03.class)
                .addAnnotatedClass(Dairy.class);

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // fetch student whose id is 1001
        Student03 student1 = session.get(Student03.class, 1001);
//        System.out.println("student1 = " + student1);

        //fetch dairy whose id is 101
        Dairy dairy = session.get(Dairy.class, 101);
//        System.out.println("dairy = " + dairy);
//        System.out.println(dairy.getStudent03());

        // print dairy name
        System.out.println(dairy.getName());

        tx.commit();
        session.close();
        sf.close();


    }
}
