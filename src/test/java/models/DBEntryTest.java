package models;

import autoscoutbackend.dal.entities.Car;
import autoscoutbackend.dal.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DBEntryTest {

    private Car car;

    @Before
    public void setUp() {
        car = new Car("BMW", "M5 E92", 25600, 32000);
    }

    @Test
    public void addEntry() {
        Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();

        int numberOfCarsBefore;
        int numberOfCarsAfter;

        try {
            session.beginTransaction();
            List cars = session.createQuery("FROM autoscoutbackend.dal.entities.Car").getResultList();
            numberOfCarsBefore = cars.size();
            session.save(car);
            cars = session.createQuery("FROM autoscoutbackend.dal.entities.Car").getResultList();
            session.getTransaction().commit();
            numberOfCarsAfter = cars.size();
        }
        finally {
            session.close();
        }
        Assert.assertEquals(numberOfCarsAfter, numberOfCarsBefore + 1);
    }
}
