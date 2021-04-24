package com.imadelfetouh.authservice.dal.signin;

import com.imadelfetouh.authservice.dal.configuration.Executer;
import com.imadelfetouh.authservice.dal.configuration.SessionType;
import com.imadelfetouh.authservice.dal.queryexecuter.SignInExecuter;
import com.imadelfetouh.authservice.dal.security.PasswordHash;
import com.imadelfetouh.authservice.dalinterface.SignInDal;
import com.imadelfetouh.authservice.model.jwt.UserData;
import com.imadelfetouh.authservice.model.response.ResponseModel;

public class SignInDB implements SignInDal {

    private Executer<UserData> executer;

    public SignInDB() {
        executer = new Executer<>(SessionType.READ);
    }

    @Override
    public ResponseModel<UserData> signIn(String username, String password) {
        String hashedPassword = PasswordHash.getInstance().hash(password);

        return executer.execute(new SignInExecuter(username, hashedPassword));
    }
}
