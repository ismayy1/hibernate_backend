package h9_fetchType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class runnerFetch09 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student09.class).addAnnotatedClass(Books09.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        Student09 student09 = session.get(Student09.class, 1001);
        System.out.println("student09 = " + student09);

//        Books09 books09 = session.get(Books09.class, 101);




        tx.commit();
        session.close();

        System.out.println("============ after the session is closed ============");
        System.out.println("=== you're able to print books properties, because you already delivered books with eager loading before the session is closed ===");
        System.out.println(student09.getBooks09List());
        // to get book name
        System.out.println(student09.getBooks09List().get(0).getName());

        sf.close();

    }
}
