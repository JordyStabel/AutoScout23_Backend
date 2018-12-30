package autoscoutbackend.dal.repository;

import autoscoutbackend.models.Car;

public class CarEntityRepository extends AbstractRepository<Car, Integer> {
    @Override
    public Class<Car> getDomainClass() {
        return Car.class;
    }
}
