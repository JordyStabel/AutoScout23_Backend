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
        carEntityRepository.save(car);
        Make make = new Make(car.getMake());

        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(new Car("Lamborghini", "Aventador SV", 1353, 425000, ""));
        make.setCarEntities(cars);
        makeEntityRepository.save(make);
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
