package h4_bi_oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch04 {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student04.class)
                .addAnnotatedClass(Dairy04.class);

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        Student04 student1 = session.get(Student04.class, 1001);
//        System.out.println("student1 = " + student1);
//        System.out.println(student1.getDairy().getName());  // to get dairy name through Student side

        Dairy04 dairy1 = session.get(Dairy04.class, 101);
        System.out.println("dairy1 = " + dairy1);
        System.out.println(dairy1.getStudent().getName());


        tx.commit();
        session.close();
        sf.close();


    }
}
