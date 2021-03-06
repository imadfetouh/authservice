package com.imadelfetouh.authservice.dal.setup;

import com.imadelfetouh.authservice.dal.configuration.QueryExecuter;
import com.imadelfetouh.authservice.dal.ormmodel.Role;
import com.imadelfetouh.authservice.dal.ormmodel.User;
import com.imadelfetouh.authservice.dal.security.PasswordHash;
import com.imadelfetouh.authservice.model.response.ResponseModel;
import com.imadelfetouh.authservice.model.response.ResponseType;
import org.hibernate.Session;

public class SetupUserDBExecuter implements QueryExecuter<Void> {

    public SetupUserDBExecuter() {

    }

    @Override
    public ResponseModel<Void> executeQuery(Session session) {
        ResponseModel<Void> responseModel = new ResponseModel<>();

        String password = PasswordHash.getInstance().hash("imad");

        User user = new User("123", "imad", password, Role.ADMINISTRATOR);
        User user1 = new User("1234", "test", "test", Role.USER);

        session.persist(user);
        session.persist(user1);

        session.getTransaction().commit();

        responseModel.setResponseType(ResponseType.CORRECT);

        return responseModel;
    }
}