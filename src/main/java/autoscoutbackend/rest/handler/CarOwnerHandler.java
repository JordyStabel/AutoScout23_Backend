package autoscoutbackend.rest.handler;

import autoscoutbackend.dal.repository.CarOwnerEntityRepository;
import autoscoutbackend.models.CarOwner;

import java.util.List;

public class CarOwnerHandler {

    private CarOwnerEntityRepository carOwnerEntityRepository = new CarOwnerEntityRepository();

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
}
