package autoscoutbackend.rest.handler;

import autoscoutbackend.dal.repository.CarEntityRepository;
import autoscoutbackend.dal.repository.CarOwnerEntityRepository;
import autoscoutbackend.dal.repository.MakeEntityRepository;
import autoscoutbackend.models.Car;
import autoscoutbackend.models.CarOwner;
import autoscoutbackend.models.Make;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CarHandler {

    private CarEntityRepository carEntityRepository = new CarEntityRepository();
    private MakeEntityRepository makeEntityRepository = new MakeEntityRepository();
    private CarOwnerEntityRepository carOwnerEntityRepository = new CarOwnerEntityRepository();

    public void SubmitCar(Car car) {

        System.out.println(car);

        Make make;
        try {
            make = makeEntityRepository.getByName(car.getMake());
        } catch (Exception e) {
            make = new Make(car.getMake());
            makeEntityRepository.save(make);
        }

        CarOwner owner;
        try {
            owner = carOwnerEntityRepository.getByName(car.getCarOwner().getUserName());
        } catch (Exception e) {
            owner = new CarOwner(car.getCarOwner().getUserName());
            carOwnerEntityRepository.save(owner);
        }

        carOwnerEntityRepository.save(owner);
        car.setCarOwner(owner);
        car.setCarMake(make);

        // For updating exciting cars
        // Only allowed to update certain fields
        if (car.getCarID() != 0) {
            Car carToUpdate = carEntityRepository.findOne(car.getCarID());
            if (carToUpdate != null) {
                carToUpdate.setModel(car.getModel());
                carToUpdate.setMileage(car.getMileage());
                carToUpdate.setPrice(car.getPrice());
                carToUpdate.setDescription(car.getDescription());
                carToUpdate.setImage(car.getImage());
                carToUpdate.setMake(car.getMake());
                carToUpdate.setCarOwner(car.getCarOwner());
                carEntityRepository.save(carToUpdate);
            }
        } else {
            carEntityRepository.save(car);
        }
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

    public void DeleteCar(Car car) {
        carEntityRepository.delete(car);
    }

    public void DeleteCarById(int id) {
        carEntityRepository.delete(id);
    }

    public List<Car> GetLatestCar() {
        return carEntityRepository.getLatestCar();
    }
}
