package autoscoutbackend.rest.handler;

import autoscoutbackend.dal.repository.MakeEntityRepository;
import autoscoutbackend.models.Car;
import autoscoutbackend.models.Make;

import java.util.List;

public class MakeHandler {

    private MakeEntityRepository makeEntityRepository = new MakeEntityRepository();

    public void AddMake(Make make) {
        makeEntityRepository.save(make);
    }

    public List<Make> GetAllMakes() {
        return makeEntityRepository.findAll();
    }

    public Make GetById(int id) {
        return makeEntityRepository.findOne(id);
    }

    public Make GetByName(String make) {
        return makeEntityRepository.getByName(make);
    }
}
