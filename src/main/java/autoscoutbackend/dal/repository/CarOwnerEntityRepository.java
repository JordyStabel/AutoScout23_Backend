package autoscoutbackend.dal.repository;

import autoscoutbackend.models.CarOwner;

public class CarOwnerEntityRepository extends AbstractRepository<CarOwner, Integer> {
    @Override
    public Class<CarOwner> getDomainClass() {
        return CarOwner.class;
    }
}
