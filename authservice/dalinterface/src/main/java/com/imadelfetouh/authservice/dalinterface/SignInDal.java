package com.imadelfetouh.authservice.dalinterface;

import com.imadelfetouh.authservice.model.jwt.UserData;
import com.imadelfetouh.authservice.model.response.ResponseModel;

public interface SignInDal {

    ResponseModel<UserData> signIn(String username, String password);
}
