package autoscoutbackend.dal.repository;

import autoscoutbackend.models.Make;

public class MakeEntityRepository extends AbstractRepository<Make, Integer> {
    @Override
    public Class<Make> getDomainClass() {
        return Make.class;
    }
}
