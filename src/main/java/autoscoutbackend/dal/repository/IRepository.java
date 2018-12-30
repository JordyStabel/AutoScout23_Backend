package autoscoutbackend.dal.repository;

import org.hibernate.Session;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public interface IRepository<T, Id extends Serializable> {

    Class<T> getDomainClass();

    Session currentSession();

    void delete(Id id);

    void delete(T entity);

    T findOne(Id id);

    List<T> findAll(T type);

    <S extends T> S add(S entity);

    @Transactional
    <S extends T> List<S> add(Iterable<S> entities);
}
