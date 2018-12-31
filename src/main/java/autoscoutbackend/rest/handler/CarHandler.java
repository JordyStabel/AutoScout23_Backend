package autoscoutbackend.rest.handler;

import autoscoutbackend.dal.repository.CarEntityRepository;
import autoscoutbackend.models.Car;

import java.util.List;

public class CarHandler {

    private CarEntityRepository carEntityRepository = new CarEntityRepository();

    public void SubmitCar(Car car){
        carEntityRepository.save(car);
    }

    public List<Car> GetAllCars(){
        return carEntityRepository.findAll();
    }

    public Car GetById(int id) {
        return carEntityRepository.findOne(id);
    }
}
