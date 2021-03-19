package com.imadelfetouh.authservice.factory.signininstance;

import com.imadelfetouh.authservice.dal.signin.SignInDB;
import com.imadelfetouh.authservice.factory.CreateInstance;

public class CreateSignInInstance implements CreateInstance {

    public CreateSignInInstance() {

    }

    @Override
    public Object create() {
        return new SignInDB();
    }
}
