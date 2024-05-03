package h5_uni_manyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch05 {
    public static void main(String[] args) {

        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student05.class)
                .addAnnotatedClass(University05.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        // get student id is 1001
        Student05 student1 = session.get(Student05.class, 1001);
        System.out.println("student1 = " + student1);

        //TASK: Fetch all students who study at university which has id 101
        String hql1 = "FROM Student05 s WHERE s.university.id = 101";
        List<Student05> resultList = session.createQuery(hql1, Student05.class).getResultList(); // (hql1, Student05.class) => mapping the output to Student05 class
//        resultList.stream().forEach(t-> System.out.println(t));
        resultList.forEach(System.out::println);    // same as above but shorter

        // write hql to get the student whose id is 1002


        tx.commit();
        session.close();
        sf.close();

    }
}
