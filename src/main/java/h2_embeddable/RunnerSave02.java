package h2_embeddable;

import h1_annotation.Student01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {

        Student02 student01 = new Student02();
        student01.setId(1001);
        student01.setName("Mikail");
        student01.setGrade(90);

        Student02 student02 = new Student02();
        student02.setId(1002);
        student02.setName("Yunus");
        student02.setGrade(98);

        Student02 student03 = new Student02();
        student03.setId(1003);
        student03.setName("Ismail");
        student03.setGrade(86);

        // set values for address
        Address address1 = new Address();
        address1.setCity("Istanbul");
        address1.setCountry("Turkey");
        address1.setStreet("Hiser");
        address1.setZipCode("239834");

        Address address2 = new Address();
        address2.setCity("Berlin");
        address2.setCountry("Germany");
        address2.setStreet("Abcs");
        address2.setZipCode("873476");

        Address address3 = new Address();
        address3.setCity("Paris");
        address3.setCountry("France");
        address3.setStreet("Blue");
        address3.setZipCode("876273");

        // set address for students
        student01.setAddress(address1);
        student02.setAddress(address2);
        student03.setAddress(address3);

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student02.class);

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        session.save(student01);
        session.save(student02);
        session.save(student03);


        tx.commit();
        session.close();
        sf.close();

    }
}
