package models;

import autoscoutbackend.dal.repository.CarEntityRepository;
import autoscoutbackend.dal.repository.MakeEntityRepository;
import autoscoutbackend.models.Car;
import autoscoutbackend.dal.*;
import autoscoutbackend.models.Make;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CarOwnerDBEntryTest {

    private Car car;
    private Make make;

    @Before
    public void setUp() {

        make = new Make("Aston Martin");
        car = new Car("Aston Martin", "Vantage", 42600, 67500, "https://hips.hearstapps.com/hmg-prod/images/2018-bmw-m2-competition-99gallery-1526572314.jpg");
        car.setCarMake(make);
    }

    @Test
    public void addCarOwner() {
        Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();

        int numberOfCarsBefore;
        int numberOfCarsAfter;

        CarEntityRepository carEntityRepository = new CarEntityRepository();
        MakeEntityRepository makeEntityRepository = new MakeEntityRepository();

        Make make;
        try{
            make = makeEntityRepository.getByName(car.getMake());
        } catch (Exception e){
            make = new Make(car.getMake());
            makeEntityRepository.save(make);
        }

        try{
            car.setCarMake(make);
            session.beginTransaction();
            List cars = session.createQuery("FROM autoscoutbackend.models.Car").getResultList();
            numberOfCarsBefore = cars.size();
            carEntityRepository.save(car);
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
