package com.imadelfetouh.authservice.dalinterface;

import com.imadelfetouh.authservice.model.dto.AuthModel;
import com.imadelfetouh.authservice.model.response.ResponseModel;

public interface SignInDal {

    ResponseModel<AuthModel> signIn(String username, String password);
}
