package autoscoutbackend.rest.handler;

import autoscoutbackend.dal.repository.CarEntityRepository;
import autoscoutbackend.dal.repository.CarOwnerEntityRepository;
import autoscoutbackend.dal.repository.MakeEntityRepository;
import autoscoutbackend.models.Car;
import autoscoutbackend.models.CarOwner;
import autoscoutbackend.models.Make;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarHandler {

    private CarEntityRepository carEntityRepository = new CarEntityRepository();
    private MakeEntityRepository makeEntityRepository = new MakeEntityRepository();
    private CarOwnerEntityRepository carOwnerEntityRepository = new CarOwnerEntityRepository();

    public void SubmitCar(Car car) {
        Make make;
        try{
            make = makeEntityRepository.getByName(car.getMake());
        } catch (Exception e){
            make = new Make(car.getMake());
            makeEntityRepository.save(make);
        }

        CarOwner owner;
        try{
            owner = carOwnerEntityRepository.getByName("Jordy");
        } catch (Exception e){
            owner = new CarOwner("Jordy");
            carOwnerEntityRepository.save(owner);
        }

        //TODO: Fetch an actual car-owner from front-end
        carOwnerEntityRepository.save(owner);
        car.setCarOwner(owner);
        car.setCarMake(make);

        // For updating exciting cars
        if (car.getCarID() != 0)
        {
            Car carToUpdate = carEntityRepository.findOne(car.getCarID());
            carToUpdate.setCarOwner(car.getCarOwner());
            carToUpdate.setCarMake(car.getCarMake());
            carToUpdate.setPrice(car.getPrice());
            carToUpdate.setMileage(car.getMileage());
            carToUpdate.setImage(car.getImage());
            carToUpdate.setModel(car.getModel());
            carEntityRepository.save(carToUpdate);
        }
        else{
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
}
