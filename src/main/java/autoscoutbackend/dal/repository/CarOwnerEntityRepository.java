package autoscoutbackend.dal.repository;

import autoscoutbackend.models.Car;
import autoscoutbackend.models.CarOwner;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class CarOwnerEntityRepository extends AbstractRepository<CarOwner, Integer> {
    @Override
    public Class<CarOwner> getDomainClass() {
        return CarOwner.class;
    }

    public CarOwner getByName(String name){
        Session session = currentSession();
        Query query = session.createQuery("SELECT e FROM CarOwner e WHERE e.userName = :name");
        query.setParameter("name", name);
        CarOwner owner = (CarOwner) query.getSingleResult();
        session.close();
        return owner;
    }


}
