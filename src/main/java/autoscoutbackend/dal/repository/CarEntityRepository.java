package autoscoutbackend.dal.repository;

import autoscoutbackend.models.Car;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.List;

public class CarEntityRepository extends AbstractRepository<Car, Integer> {
    @Override
    public Class<Car> getDomainClass() {
        return Car.class;
    }

    public List<Car> getByMake(String make){
        Session session = currentSession();
        Query query = session.createQuery("SELECT e FROM Car e WHERE e.make = :makeName");
        query.setParameter("makeName", make);
        List<Car> resultList = query.getResultList();
        session.close();
        return resultList;
    }

    public List<Car> getLatestCar(){
        Session session = currentSession();
        Query query = session.createQuery("SELECT e FROM Car e ORDER BY e.date_created desc");
        query.setMaxResults(1);
        List<Car> result = query.getResultList();
        session.close();
        return result;
    }
}
