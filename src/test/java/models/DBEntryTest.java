package models;

import autoscoutbackend.models.Car;
import autoscoutbackend.dal.*;
import autoscoutbackend.models.Make;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DBEntryTest {

    private Car car;

    @Before
    public void setUp() {
        car = new Car("BMW", "M5 E92", 25600, 32000, "https://hips.hearstapps.com/hmg-prod/images/2018-bmw-m2-competition-99gallery-1526572314.jpg");
    }

    @Test
    public void addEntry() {
        Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();

        int numberOfCarsBefore;
        int numberOfCarsAfter;

        try {
            session.beginTransaction();
            List cars = session.createQuery("FROM autoscoutbackend.models.Car").getResultList();
            numberOfCarsBefore = cars.size();
            session.save(car);
            cars = session.createQuery("FROM autoscoutbackend.models.Car").getResultList();
            session.getTransaction().commit();
            numberOfCarsAfter = cars.size();
        }
        finally {
            session.close();
        }
        Assert.assertEquals(numberOfCarsAfter, numberOfCarsBefore + 1);
    }
}
