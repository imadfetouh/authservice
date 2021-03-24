package com.imadelfetouh.authservice.factory;

import com.imadelfetouh.authservice.dal.signin.SignInDB;
import com.imadelfetouh.authservice.dalinterface.SignInDal;
import com.imadelfetouh.authservice.factory.signininstance.CreateSignInInstance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactoryTest {

    @Test
    public void testInstance() {
        Factory factory = Factory.getInstance();
        Factory factory1 = Factory.getInstance();

        Assertions.assertEquals(factory, factory1);
    }

    @Test
    public void testSignInInstance() {
        Object o = Factory.getInstance().buildInstance(new CreateSignInInstance());

        Assertions.assertEquals(SignInDB.class.getName(), o.getClass().getName());
    }
}
