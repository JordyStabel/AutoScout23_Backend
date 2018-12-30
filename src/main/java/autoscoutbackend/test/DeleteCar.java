package autoscoutbackend.test;

import autoscoutbackend.models.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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

            // Delete car
            //session.delete(car);
            session.createQuery("DELETE FROM dal.entities.Car WHERE id = '2'").executeUpdate();
            // Commit the transaction
            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
