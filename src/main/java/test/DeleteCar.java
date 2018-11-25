package test;

import dal.entities.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class DeleteCar {

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
            int carId = 1;

            // Start a transaction
            session.beginTransaction();

            // Get a car with correct id
            Car car = session.get(Car.class, carId);

            // Update create data
            Random random = new Random();
            car.setPrice((random.nextInt(50000) * random.nextInt(10)));
            car.setMileage((random.nextInt(10000) * random.nextInt(10)));

            // Commit the transaction
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("UPDATE dal.entities.Car SET test_date = '2018-11-25'")
                    .executeUpdate();

            session.getTransaction().commit();

            session.close();
        }
        finally {
            sessionFactory.close();
        }
    }
}
