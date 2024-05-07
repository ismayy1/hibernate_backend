package h7_bi_oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {
    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


//        Student07 student1 = session.get(Student07.class, 1001);
//        System.out.println(student1);
//        student1.getBook07List().forEach(System.out::println);

        //TASK: fetch students and their name
//        String hql1 = "SELECT s.name, b.name FROM Student07 s INNER JOIN FETCH Book07 b ON b.student.id = s.id";
//        List<Object[]> resultList1 = session.createQuery(hql1).getResultList();
//        resultList1.forEach(t-> System.out.println("t = " + Arrays.toString(t)));

        // DELETE Student07
//        String hql2 = "DELETE FROM Student07";
//        int nrOfUpdatedRowStudent = session.createQuery(hql2).executeUpdate();
//        System.out.println("nrOfUpdatedRowStudent = " + nrOfUpdatedRowStudent);

        // in order to delete Student07, first you need to delete Book07 table
//        String hql3 = "DELETE FROM Book07";
//        int nrOfUpdatedRowBook = session.createQuery(hql3).executeUpdate();
//        System.out.println("nrOfUpdatedRowBook = " + nrOfUpdatedRowBook);

        // delete student whose id is 1001
//        String hql4 = "DELETE FROM Student07 s WHERE s.id = 1001";
//        int numOfDeleted = session.createQuery(hql4).executeUpdate();
//        System.out.println("numOfDeleted = " + numOfDeleted);

        /*
            to delete students who have books, there are two ways
                1. delete books first, and then delete student
                2. for student class we can cascade type as Remove (or ALL), or set the 'orphanRemoval = true'
         */
//        Student07 student07 = session.get(Student07.class, 1001);
//        session.delete(student07);

        Student07 student3 = session.get(Student07.class, 1002);
        student3.getBook07List().set(0, null);
        System.out.println("student3 = " + student3);

        tx.commit();
        session.close();
        sf.close();

    }
}
