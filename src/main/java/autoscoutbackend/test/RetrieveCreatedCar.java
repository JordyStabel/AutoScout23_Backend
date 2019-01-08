package autoscoutbackend.test;

import autoscoutbackend.models.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RetrieveCreatedCar {

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

            // Create 3 new Car object
            System.out.println("Create new cars");
            Car newCar1 = new Car("Seat", "Ibiza", "Very nice car, great build quality too...",135900, 4500, "https://prod.pictures.autoscout24.net/listing-images/f17ca69a-b0cd-4f88-9196-c9f3c9f81b74_0b5c8001-2706-478b-8d55-54c1c33a7ffc.jpg/640x480.jpg");

            // Start a transaction
            System.out.println("Starting transaction");
            session.beginTransaction();

            // Save the Car object
            System.out.println("Saving new object");
            session.save(newCar1);

            // Commit transaction
            System.out.println("Commiting transaction");
            session.getTransaction().commit();

            // Retrieve the id of the new car: primary key
            int id = newCar1.getCarID();

            // Get new session and start transaction
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Retrieve car based on the id: primary key
            System.out.println("Getting car with id: " + id);
            Car retrievedCar = session.get(Car.class, id);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println(retrievedCar.toString());
        }
        finally {
            sessionFactory.close();
        }
    }
}
