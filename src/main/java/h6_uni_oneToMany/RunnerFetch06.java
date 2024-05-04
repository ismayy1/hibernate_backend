package h6_uni_oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {


        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student06.class)
                .addAnnotatedClass(Book06.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


//        Student06 student1 = session.get(Student06.class, 1001);
//        System.out.println("student1 = " + student1);
//        System.out.println("student1.getName() = " + student1.getName());
//        System.out.println(student1.getBookList().get(0).getName());

        //TASK: Using hql, fetch book whose id is 101
//        String hql1 = "FROM Book06 b WHERE b.id = 101";
//        Book06 book1 = session.createQuery(hql1, Book06.class).getSingleResult();
//        System.out.println("book1 = " + book1);

        //TASK: get the above task result using get
//        Book06 book2 = session.get(Book06.class, 101);
//        System.out.println("book2 = " + book2);

        //TASK: using hql bring books of student whose id is 1002
        System.out.println("=================== Same result with HQL ====================");
        String hql2 = "SELECT b.id, b.name FROM Student06 s INNER JOIN s.bookList b WHERE s.id = 1002";
        List<Object[]> resultList = session.createQuery(hql2).getResultList();
        resultList.forEach(t-> System.out.println("t = " + Arrays.toString(t)));

        System.out.println("=================== Same result with get() ====================");
        Student06 student06 = session.get(Student06.class, 1002);
        System.out.println("student06.getBookList() = " + student06.getBookList());



        tx.commit();
        session.close();
        sf.close();

    }
}
