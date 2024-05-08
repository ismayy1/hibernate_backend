package h14_hibernateLifeCicle2;

import h12_get_load.Student12;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {
    public static void main(String[] args) {

        Employee14 employee1 = new Employee14();
        employee1.setName("Mikail");
        employee1.setSalary(5000.0);


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee14.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();





        tx.commit();
        session.close();
        sf.close();



    }
}
