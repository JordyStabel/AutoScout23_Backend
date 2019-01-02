package models;

import autoscoutbackend.dal.repository.CarEntityRepository;
import autoscoutbackend.dal.repository.CarOwnerEntityRepository;
import autoscoutbackend.dal.repository.MakeEntityRepository;
import autoscoutbackend.models.Car;
import autoscoutbackend.dal.*;
import autoscoutbackend.models.CarOwner;
import autoscoutbackend.models.Make;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CarOwnerDBEntryTest {

    private CarOwner carOwner;

    @Before
    public void setUp() {
        carOwner = new CarOwner("Jordy");
    }

    @Test
    public void addCarOwner() {
        Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();

        int numberOfCarOwnersBefore;
        int numberOfCarOwnersAfter;

        CarOwnerEntityRepository carOwnerEntityRepository = new CarOwnerEntityRepository();

        try{
            session.beginTransaction();
            List owners = session.createQuery("FROM autoscoutbackend.models.CarOwner").getResultList();
            numberOfCarOwnersBefore = owners.size();
            carOwnerEntityRepository.save(carOwner);
            owners = session.createQuery("FROM autoscoutbackend.models.CarOwner").getResultList();
            session.getTransaction().commit();
            numberOfCarOwnersAfter = owners.size();
        }
        finally {
            session.close();
        }

        Assert.assertEquals(numberOfCarOwnersAfter, numberOfCarOwnersBefore + 1);
    }
}
