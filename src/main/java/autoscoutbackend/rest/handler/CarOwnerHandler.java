package autoscoutbackend.rest.handler;

import autoscoutbackend.dal.repository.CarEntityRepository;
import autoscoutbackend.dal.repository.CarOwnerEntityRepository;
import autoscoutbackend.models.Car;
import autoscoutbackend.models.CarOwner;

import java.util.List;
import java.util.Set;

public class CarOwnerHandler {

    private CarOwnerEntityRepository carOwnerEntityRepository = new CarOwnerEntityRepository();
    private CarEntityRepository carEntityRepository = new CarEntityRepository();

    public void AddCarOwner(CarOwner carOwner) {
        carOwnerEntityRepository.save(carOwner);
    }

    public List<CarOwner> GetAllUsers() {
        return carOwnerEntityRepository.findAll();
    }

    public CarOwner GetById(int id) {
        return carOwnerEntityRepository.findOne(id);
    }

    public CarOwner GetByName(String name) {
        return carOwnerEntityRepository.getByName(name);
    }

    public void AddFavoriteCar(CarOwner carOwner, int carID) {
        CarOwner owner;
        try {
            owner = carOwnerEntityRepository.getByName(carOwner.getUserName());
        } catch (Exception e) {
            owner = new CarOwner("Henk");
            carOwnerEntityRepository.save(owner);
        }

        Set<Car> favoriteCars = owner.getFavoriteCars();
        Car favoriteCar = carEntityRepository.findOne(carID);
        favoriteCars.add(favoriteCar);

        owner.setFavoriteCars(favoriteCars);
        carOwnerEntityRepository.save(owner);
    }

    public void RemoveCarOwnerById (int id) {
        carOwnerEntityRepository.delete(id);
    }
}
