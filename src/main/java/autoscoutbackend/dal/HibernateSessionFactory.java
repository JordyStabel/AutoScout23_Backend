package autoscoutbackend.dal;

import autoscoutbackend.models.Car;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

    private static SessionFactory sessionFactory = buildNewSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Create and return a Hibernate SessionFactory with correct configuration.
     * @return
     * Returns a new Hibernate SessionFactory
     */
    private static SessionFactory buildNewSessionFactory(){
        return new Configuration()
                .configure("hibernate.cfg.xml")
                //.addAnnotatedClass(Car.class)
                .buildSessionFactory();
    }
}
