package com.imadelfetouh.authservice.dal.configuration;

import com.imadelfetouh.authservice.dal.ormmodel.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.SessionFactoryServiceRegistryBuilder;

import java.util.Properties;

public class SessionConfiguration {

    private static final SessionConfiguration sessionConfiguration = new SessionConfiguration();
    private final SessionFactory sessionFactory;

    private SessionConfiguration() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://"+System.getenv("AUTHSERVICE_MYSQL_HOST")+":3307/authservice");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "imad");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MariaDBDialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.HBM2DDL_AUTO, "none");
        properties.put(Environment.C3P0_MIN_SIZE, "1");
        properties.put(Environment.C3P0_MAX_SIZE, "2");
        properties.put(Environment.C3P0_ACQUIRE_INCREMENT, "1");
        properties.put(Environment.C3P0_TIMEOUT, "1800");
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);

        sessionFactory = configuration.configure().buildSessionFactory();
    }

    public static SessionConfiguration getInstance() {
        return sessionConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
