package com.imadelfetouh.authservice.dal;

import com.imadelfetouh.authservice.dal.configuration.Executer;
import com.imadelfetouh.authservice.dal.configuration.SessionType;
import com.imadelfetouh.authservice.dal.security.PasswordHash;
import com.imadelfetouh.authservice.dal.setup.SetupUserDBExecuter;
import com.imadelfetouh.authservice.dal.signin.SignInDB;
import com.imadelfetouh.authservice.dalinterface.SignInDal;
import com.imadelfetouh.authservice.model.jwt.UserData;
import com.imadelfetouh.authservice.model.response.ResponseModel;
import com.imadelfetouh.authservice.model.response.ResponseType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SignInDBTest {

    @BeforeAll
    public static void setUpDatabase() {
        Executer<Void> executer = new Executer<>(SessionType.WRITE);
        executer.execute(new SetupUserDBExecuter());
    }

    @Test
    public void testUserSignInCorrect() {
        SignInDal signInDal = new SignInDB();
        ResponseModel<UserData> responseModel = signInDal.signIn("imad", "imad");

        Assertions.assertEquals(ResponseType.CORRECT, responseModel.getResponseType());
        Assertions.assertEquals("imad", responseModel.getData().getUsername());
    }

    @Test
    public void testUserSignInIncorrect() {
        SignInDal signInDal = new SignInDB();
        ResponseModel<UserData> responseModel = signInDal.signIn("imad", "test");

        Assertions.assertEquals(ResponseType.WRONGCREDENTIALS, responseModel.getResponseType());
        Assertions.assertNull(responseModel.getData());
    }
}
