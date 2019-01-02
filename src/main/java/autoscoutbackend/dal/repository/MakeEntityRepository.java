package autoscoutbackend.dal.repository;

import autoscoutbackend.models.Car;
import autoscoutbackend.models.Make;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class MakeEntityRepository extends AbstractRepository<Make, Integer> {
    @Override
    public Class<Make> getDomainClass() {
        return Make.class;
    }

    public Make getByName(String make){
        Session session = currentSession();
        Query query = session.createQuery("SELECT e FROM Make e WHERE e.make = :makeName");
        query.setParameter("makeName", make);
        Make result = (Make)query.getSingleResult();
        session.close();
        return result;
    }
}
