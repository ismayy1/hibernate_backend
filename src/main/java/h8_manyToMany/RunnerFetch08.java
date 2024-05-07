package h8_manyToMany;

import h11_cacheLevels.Student11;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {
    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student08.class).addAnnotatedClass(Book08.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


//        Student08 student08 = session.get(Student08.class, 1001);
//        System.out.println("student08 = " + student08);

        Book08 book08 = session.get(Book08.class, 101);
//        System.out.println("book08 = " + book08);
        System.out.println(book08.getStudent08List());


        tx.commit();
        session.close();
        sf.close();


    }
}
