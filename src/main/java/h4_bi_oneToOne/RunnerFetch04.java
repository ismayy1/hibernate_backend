package h4_bi_oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

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

//        Dairy04 dairy1 = session.get(Dairy04.class, 101);
//        System.out.println("dairy1 = " + dairy1);
//        System.out.println(dairy1.getStudent().getName());


        System.out.println("=============== with query ===============");
        // Fetch student whose dairy's id 101, use hql
//        String hqlQuery1 = "SELECT s.name FROM Student04 s INNER JOIN FETCH Dairy04 d ON s.id = d.student WHERE d.id = 101";

//        String std_nameHQL = (String) session.createQuery(hqlQuery1).getSingleResult();
//        System.out.println("std_nameHQL = " + std_nameHQL);

        // TASK: Fetch all students and dairies if they have
        String hqlQuery2 = "SELECT s.name, s.grade, d.name FROM Student04 s LEFT JOIN FETCH Dairy04 d ON s.id = d.student";
        List<Object[]> resultList = session.createQuery(hqlQuery2).getResultList();

        for (Object[] results: resultList) {
            System.out.println("results = " + Arrays.toString(results));
        }

        System.out.println("================================");
        resultList.stream().forEach(oa-> System.out.println(Arrays.toString(oa)));


        tx.commit();
        session.close();
        sf.close();

    }
}