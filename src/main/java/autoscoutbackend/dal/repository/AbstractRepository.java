package autoscoutbackend.dal.repository;

import autoscoutbackend.dal.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractRepository<T, Id extends Serializable> implements IRepository<T, Id> {

    private static String entityIsNull = "Entity (or entities) can't be null";

    @Override
    public Session currentSession() {
        return HibernateSessionFactory.getSessionFactory().openSession();
    }

    @Override
    public <S extends T> S add(S entity) {

        if (entity == null) {
            throw new IllegalArgumentException(entityIsNull);
        }

        Session session = currentSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            session.saveOrUpdate(entity);

            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null)
                transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }

        return null;
    }

    @Override
    @Transactional
    public <S extends T> List<S> add(Iterable<S> entities) {

        if (entities == null) {
            throw new IllegalArgumentException(entityIsNull);
        }

        List<S> result = new ArrayList<>();

        Session session = currentSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            entities.forEach(entity -> {
                session.saveOrUpdate(entity);
                result.add(entity);
            });
            transaction.commit();
            return result;
        } catch (RuntimeException e) {
            if (transaction != null)
                transaction.rollback();
            System.out.println(e.getMessage());

        } finally {
            session.close();
        }

        return Collections.emptyList();
    }

    @Override
    public T findOne(Id id) {

        Class<T> classType = getDomainClass();
        T entity = null;

        Session session = currentSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            entity = session.get(classType, id);
            transaction.commit();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }

        return entity;
    }

    @Override
    public List<T> findAll(T type){
        Session session = currentSession();

        List<T> entities;

        try {
            session.beginTransaction();
            Class<T> classType = getDomainClass();
            entities = session.createQuery("FROM " + classType).getResultList();
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }

        return entities;
    }

    @Override
    public void delete(Id id) {

        T entity = findOne(id);

        if (entity == null) {
            throw new IllegalArgumentException(entityIsNull);
        }

        deleteEntity(entity);
    }

    @Override
    public void delete(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException(entityIsNull);
        }

        deleteEntity(entity);
    }

    private void deleteEntity(T entity){
        Session session = currentSession();

        try {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
    }
}
