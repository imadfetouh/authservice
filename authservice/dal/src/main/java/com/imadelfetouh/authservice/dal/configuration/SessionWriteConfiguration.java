package com.imadelfetouh.authservice.dal.configuration;

import com.imadelfetouh.authservice.dal.ormmodel.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class SessionWriteConfiguration {

    private final static SessionWriteConfiguration sessionWriteConfiguration = new SessionWriteConfiguration();
    private final ReadWriteConfiguration readWriteConfiguration;
    private final SessionFactory sessionFactory;

    public SessionWriteConfiguration() {
        readWriteConfiguration = ReadWriteConfiguration.getInstance();
        Configuration configuration = new Configuration();

        Properties properties = readWriteConfiguration.getProperties();
        configuration.addProperties(properties);
        configuration.getProperties().put(Environment.URL, "jdbc:mysql://"+System.getenv("AUTHSERVICE_MYSQL_MASTER_HOST")+":"+System.getenv("AUTHSERVICE_MYSQL_MASTER_PORT")+"/authservice?createDatabaseIfNotExist=true");

        configuration.addAnnotatedClass(User.class);

        sessionFactory = configuration.configure().buildSessionFactory();
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public static SessionWriteConfiguration getInstance() {
        return sessionWriteConfiguration;
    }
}
