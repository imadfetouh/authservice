package com.imadelfetouh.authservice.model;

import com.imadelfetouh.authservice.model.response.ResponseModel;
import com.imadelfetouh.authservice.model.response.ResponseType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResponseModelTest {

    @Test
    public void testResponseModelConstructor() {
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        responseModel.setData(200);
        responseModel.setResponseType(ResponseType.CORRECT);

        Assertions.assertEquals(200, responseModel.getData());
        Assertions.assertEquals(ResponseType.CORRECT, responseModel.getResponseType());
    }
}
