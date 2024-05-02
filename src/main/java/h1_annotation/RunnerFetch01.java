package h1_annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.Select;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {

        // provide information about the config file and entity object
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        /*
            To fetch the data from DB: there are 3 different ways:
                1. .get()
                2. SQL
                3. HQL
         */

        // .get() =====================
//        Student01 student01 = session.get(Student01.class, 1001);
//        System.out.println("student01 = " + student01);

//        Student01 student02 = session.get(Student01.class, 1002);
//        System.out.println("student02 = " + student02);
//        System.out.println(student02.getName());

        // SQL: =======================
//        String sqlQuery = "SELECT * FROM t_student01";
//        List<Object[]> resultList = session.createSQLQuery(sqlQuery).getResultList();
//        for (Object[] objects: resultList) {
//            System.out.println(Arrays.toString(objects));
//        }

        // HQL: =======================
//        String hqlQuery01 = "FROM Student01";   // unlike SQL, we have to use java language
//        List<Student01> resultList01 = session.createQuery(hqlQuery01, Student01.class).getResultList();
//        for (Student01 student01: resultList01) {
//            System.out.println("student01 = " + student01);
//        }

        // TASK: return students sorted by id in descending order
//        String hqlQuery02 = "FROM Student01 s ORDER BY s.id DESC";
//        List<Student01> resultList02 = session.createQuery(hqlQuery02, Student01.class).getResultList();
//        for (Student01 student01: resultList02) {
//            System.out.println("student01 = " + student01);
//        }

        // TASK: return student whose name is "Yunus"
        String hqlQuery03 = "FROM Student01 WHERE name = 'Yunus'";

        Student01 student04 = (Student01) session.createQuery(hqlQuery03, Student01.class).getSingleResult();
        System.out.println("student04 = " + student04);

        transaction.commit();   // if not committed changes/updates will not be updated in DB
        session.close();
        sf.close();

    }
}
