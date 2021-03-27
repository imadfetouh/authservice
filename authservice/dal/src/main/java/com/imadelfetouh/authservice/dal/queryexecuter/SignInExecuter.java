package com.imadelfetouh.authservice.dal.queryexecuter;

import com.imadelfetouh.authservice.dal.configuration.QueryExecuter;
import com.imadelfetouh.authservice.dal.ormmodel.User;
import com.imadelfetouh.authservice.model.dto.AuthModel;
import com.imadelfetouh.authservice.model.response.ResponseModel;
import com.imadelfetouh.authservice.model.response.ResponseType;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignInExecuter implements QueryExecuter<AuthModel> {

    private static final Logger logger = Logger.getLogger(SignInExecuter.class.getName());

    private String username;
    private String password;

    public SignInExecuter(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public ResponseModel<AuthModel> executeQuery(Session session) {
        ResponseModel<AuthModel> responseModel = new ResponseModel<>();

        Query query = session.createQuery("SELECT new com.imadelfetouh.authservice.model.dto.AuthModel(u.id, u.password, u.photo) FROM User u WHERE u.username = :username AND u.password = :password");
        query.setParameter("username", this.username);
        query.setParameter("password", this.password);

        try {
            AuthModel authModel = (AuthModel) query.getSingleResult();
            responseModel.setData(authModel);
            responseModel.setResponseType(ResponseType.CORRECT);
        }
        catch (NoResultException e){
            logger.log(Level.ALL, e.getMessage());
            responseModel.setResponseType(ResponseType.WRONGCREDENTIALS);
        }

        return responseModel;
    }
}
