package com.imadelfetouh.authservice.dal;

import com.imadelfetouh.authservice.dal.signin.SignInDB;
import com.imadelfetouh.authservice.dalinterface.SignInDal;
import com.imadelfetouh.authservice.model.response.ResponseModel;
import com.imadelfetouh.authservice.model.response.ResponseType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SignInDBTest {

    @Test
    public void testUserSignInCorrect() {
        SignInDal signInDal = new SignInDB();
        ResponseModel<Integer> responseModel = signInDal.signIn("imad", "imad");

        Assertions.assertEquals(ResponseType.CORRECT, responseModel.getResponseType());
    }
}
