package autoscoutbackend.rest.handler;

import autoscoutbackend.dal.repository.CarEntityRepository;
import autoscoutbackend.models.Car;
import autoscoutbackend.test.GetCars;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CarHandler {

    private CarEntityRepository carEntityRepository = new CarEntityRepository();

    public void SubmitCar(Car car){
        carEntityRepository.add(car);
    }

    public List<Car> GetAllCars(){

        Session session = carEntityRepository.currentSession();
        List cars;

        try {
            session.beginTransaction();
            cars = session.createQuery("FROM autoscoutbackend.models.Car").getResultList();
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }

        return cars;
    }

    public Car GetById(int id) {
        return carEntityRepository.findOne(id);
    }
}
