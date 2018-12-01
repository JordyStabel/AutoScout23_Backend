package autoscoutbackend.test;

import autoscoutbackend.dal.entities.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetCars {

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

            // Start a transaction
            System.out.println("Starting transaction");
            session.beginTransaction();

            // Query Cars
            List cars = session.createQuery("FROM dal.entities.Car").getResultList();

            // Display all Cars
            for (Object car : cars){
                System.out.println(car);
            }

            List ferraris = session.createQuery("FROM dal.entities.Car AS car WHERE car.make = 'Ferrari'").getResultList();
            for (Object ferrari : ferraris){
                System.out.println(ferrari);
            }

            // Commit the transaction
            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
