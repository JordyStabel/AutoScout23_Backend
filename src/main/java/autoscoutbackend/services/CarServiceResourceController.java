package autoscoutbackend.services;

import autoscoutbackend.dal.entities.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class CarServiceResourceController {

    @RequestMapping("/cars")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Car> getCar() {
        List cars = null;

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
            session.beginTransaction();

            // Query Cars
            cars = session.createQuery("FROM dal.entities.Car").getResultList();

            sessionFactory.close();
        }
        finally {
            sessionFactory.close();
        }

        return cars;
    }

    @RequestMapping("/car")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getTimeMessage(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    @RequestMapping("/autoscoutbackend/test")
    @CrossOrigin(origins = "http://localhost:3000")
    public String runTest(){
        return "This is a autoscoutbackend.test, returning a string....this.";
    }

    @RequestMapping(value = "/new") //, method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public void newproduct(){//@RequestBody String json) {

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
            Car newCar = new Car("Porsche", "918 Spyder", 2600, 1995000);

            // Start a transaction
            session.beginTransaction();

            // Save the Car object
            session.save(newCar);

            // Commit transaction
            session.getTransaction().commit();

            System.out.println("Done: " + newCar.toString());

            sessionFactory.close();
        }
        finally {
            sessionFactory.close();
        }
    }
}

