module dal {
    requires org.hibernate.orm.core;
    requires org.hibernate.commons.annotations;
    requires java.persistence;
    requires java.naming;
    requires java.sql;
    requires dalinterface;
    requires model;
    requires com.rabbitmq.client;
    requires com.google.gson;

    exports com.imadelfetouh.authservice.dal.signin;
    exports com.imadelfetouh.authservice.dal.configuration;
    exports com.imadelfetouh.authservice.dal.queryexecuter;
    exports com.imadelfetouh.authservice.dal.security;

    opens com.imadelfetouh.authservice.dal.ormmodel;
    exports com.imadelfetouh.authservice.dal.rabbit.thread;
}