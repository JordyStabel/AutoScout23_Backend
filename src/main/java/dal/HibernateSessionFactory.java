package dal;

import dal.entities.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

    public static void main(String[] args){

        // Create new session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .buildSessionFactory();

        // Create session
        Session session = sessionFactory.getCurrentSession();

        try {
            // Use the session object to save Java object to database

            // Create a new Car object
            System.out.println("Creating new car");
            Car newCar = new Car("Ferrari", "F430 Spider", 23600, 95000);

            // Start a transaction
            System.out.println("Starting transaction");
            session.beginTransaction();

            // Save the Car object
            System.out.println("Saving new object");
            session.save(newCar);

            // Commit transaction
            System.out.println("Commiting transaction");
            session.getTransaction().commit();

            System.out.println("Done, new car added to database");
        }
        finally {
            sessionFactory.close();
        }
    }
}
