package h12_get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch12 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student12.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


//        System.out.println("======== get() ========");
//        Student12 student1 = session.get(Student12.class, 1L);
//        System.out.println("======== End get() ========");
//
//        System.out.println("student1.getId() = " + student1.getId());
//        System.out.println("student1.getName() = " + student1.getName());
//
//
//
//        System.out.println("======== load() ========");
//        Student12 student2 = session.load(Student12.class, 2L);
//        System.out.println("======== End load() ========");
//
//        System.out.println("student2.getId() = " + student2.getId());
//        System.out.println("student2.getName() = " + student2.getName());
//        System.out.println("student2.getGrade() = " + student2.getGrade());


        // when to use load
        // TASK: delete student whose id is 3
//        Student12 student3 = session.get(Student12.class, 3L);
//        session.delete(student3);
//
//        Student12 student4 = session.load(Student12.class, 3L);
//        session.delete(student4);

        // TASK: UPDATE student name to 'Jerry'
//        Student12 student4 = session.load(Student12.class, 3L);
//        student4.setName("Jerry");


        System.out.println("======== get() ========");
        Student12 student5 = session.get(Student12.class, 11L); // if data is not in DB, it returns null
        System.out.println("======== End get() ========");


        if (student5 != null) {
            System.out.println("student5.getGrade() = " + student5.getGrade());
        }


        System.out.println("======== load() ========");
        Student12 student6 = session.load(Student12.class, 19L);    // creates fake obj, and sets the id 19
        System.out.println("======== End load() ========");

        // student 6 is not null, it's proxy/fake object
        if (student6 != null) {
            System.out.println("getId() = " + student6.getId());   // prints the id of the fake object, the id we searched for (19)
            System.out.println("getName() = " + student6.getName());   // gives an ObjectNotFoundException bcs it needs to go to the DB
        }

        System.out.println("=============== no exception ================");





        tx.commit();
        session.close();
        sf.close();

    }
}
