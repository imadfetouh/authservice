module dal {
    requires org.hibernate.orm.core;
    requires org.hibernate.commons.annotations;
    requires java.persistence;
    requires java.naming;
    requires java.sql;
    requires dalinterface;
    requires model;

    exports com.imadelfetouh.authservice.dal.signin;
    exports com.imadelfetouh.authservice.dal.configuration;
    exports com.imadelfetouh.authservice.dal.queryexecuter;

    opens com.imadelfetouh.authservice.dal.ormmodel;
}