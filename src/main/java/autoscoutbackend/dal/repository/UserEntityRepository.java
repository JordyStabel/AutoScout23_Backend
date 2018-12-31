package autoscoutbackend.dal.repository;

import autoscoutbackend.models.User;

public class UserEntityRepository extends AbstractRepository<User, Integer> {
    @Override
    public Class<User> getDomainClass() {
        return User.class;
    }
}
