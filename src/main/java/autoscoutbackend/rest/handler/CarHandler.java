package autoscoutbackend.rest.handler;

import autoscoutbackend.dal.repository.CarEntityRepository;
import autoscoutbackend.dal.repository.MakeEntityRepository;
import autoscoutbackend.models.Car;
import autoscoutbackend.models.Make;

import java.util.ArrayList;
import java.util.List;

public class CarHandler {

    private CarEntityRepository carEntityRepository = new CarEntityRepository();
    private MakeEntityRepository makeEntityRepository = new MakeEntityRepository();

    public void SubmitCar(Car car) {
        Make make;
        try{
            make = makeEntityRepository.getByName(car.getMake());
        } catch (Exception e){
            make = new Make(car.getMake());
            makeEntityRepository.save(make);
        }
        car.setCarMake(make);
        carEntityRepository.save(car);
    }

    public List<Car> GetAllCars() {
        return carEntityRepository.findAll();
    }

    public Car GetById(int id) {
        return carEntityRepository.findOne(id);
    }

    public List<Car> GetByMake(String make) {
        return carEntityRepository.getByMake(make);
    }
}
