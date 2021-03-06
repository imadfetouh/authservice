package com.imadelfetouh.authservice.rest;

import com.imadelfetouh.authservice.dal.security.PasswordHash;
import com.imadelfetouh.authservice.rest.endpoints.SignInResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class SignInResourceTest {


    @Test
    public void testUserSignInIncorrect() {
        SignInResource signInResource = new SignInResource();
        String username = "imad";
        String password = "test";

        Response response = signInResource.signIn(username, password);

        Assertions.assertEquals(400, response.getStatus());
    }
}
