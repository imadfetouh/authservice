package com.imadelfetouh.authservice.model;

import com.imadelfetouh.authservice.model.dto.AuthModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AuthModelTest {

    @Test
    public void testConstructor() {
        AuthModel authModel = new AuthModel(1, "imad", "user.jpg");

        Assertions.assertEquals(1, authModel.getUserId());
        Assertions.assertEquals("imad", authModel.getUsername());
        Assertions.assertEquals("user.jpg", authModel.getPhoto());
    }

    @Test
    public void testGettersAndSetters() {
        AuthModel authModel = new AuthModel();
        authModel.setUserId(1);
        authModel.setUsername("imad");
        authModel.setPhoto("user.jpg");

        Assertions.assertEquals(1, authModel.getUserId());
        Assertions.assertEquals("imad", authModel.getUsername());
        Assertions.assertEquals("user.jpg", authModel.getPhoto());
    }
}
