package com.imadelfetouh.authservice.dal.queryexecuter;

import com.imadelfetouh.authservice.dal.configuration.QueryExecuter;
import com.imadelfetouh.authservice.dal.ormmodel.Role;
import com.imadelfetouh.authservice.dal.ormmodel.User;
import com.imadelfetouh.authservice.model.dto.NewUserDTO;
import com.imadelfetouh.authservice.model.response.ResponseModel;
import com.imadelfetouh.authservice.model.response.ResponseType;
import org.hibernate.Session;

public class AddUserExecuter implements QueryExecuter<Void> {

    private NewUserDTO newUserDTO;

    public AddUserExecuter(NewUserDTO newUserDTO) {
        this.newUserDTO = newUserDTO;
    }

    @Override
    public ResponseModel<Void> executeQuery(Session session) {
        ResponseModel<Void> responseModel = new ResponseModel<>();

        User user = new User(newUserDTO.getUserId(), newUserDTO.getUsername(), newUserDTO.getPassword(), Role.valueOf(newUserDTO.getRole()));

        session.persist(user);

        session.getTransaction().commit();

        responseModel.setResponseType(ResponseType.CORRECT);

        return responseModel;
    }
}
