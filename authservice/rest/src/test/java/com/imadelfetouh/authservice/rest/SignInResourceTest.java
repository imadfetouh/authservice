package com.imadelfetouh.authservice.rest;

import com.imadelfetouh.authservice.rest.endpoints.SignInResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class SignInResourceTest {

    @Test
    public void testUserSignInCorrect() {
        SignInResource signInResource = new SignInResource();
        String username = "imad";
        String password = "imad";

        Response response = signInResource.signIn(username, password);

        Assertions.assertEquals(200, response.getStatus());
    }
}
