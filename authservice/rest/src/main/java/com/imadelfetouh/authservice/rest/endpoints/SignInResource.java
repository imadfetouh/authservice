package com.imadelfetouh.authservice.rest.endpoints;

import com.google.gson.Gson;
import com.imadelfetouh.authservice.dalinterface.SignInDal;
import com.imadelfetouh.authservice.factory.Factory;
import com.imadelfetouh.authservice.factory.signininstance.CreateSignInInstance;
import com.imadelfetouh.authservice.model.jwt.UserData;
import com.imadelfetouh.authservice.model.response.ResponseModel;
import com.imadelfetouh.authservice.model.response.ResponseType;
import com.imadelfetouh.authservice.rest.jwt.CreateJWTToken;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Path("/signin")
public class SignInResource {

    private final static Logger logger = Logger.getLogger(SignInResource.class.getName());

    private SignInDal signInDal;

    public SignInResource() {
        this.signInDal = (SignInDal) Factory.getInstance().buildInstance(new CreateSignInInstance());
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response signIn(@FormParam("username") String username, @FormParam("password") String password) {

        logger.info("Sign in request: username: " + username + " and password: " + password);

        if(username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()){
            return Response.status(400).build();
        }

        ResponseModel<UserData> responseModel = signInDal.signIn(username, password);

        if(responseModel.getResponseType().equals(ResponseType.ERROR)){
            return Response.status(500).build();
        }

        if(responseModel.getResponseType().equals(ResponseType.WRONGCREDENTIALS)){
            return Response.status(400).build();
        }

        Gson gson = new Gson();

        Map<String, String> claims = new HashMap<>();
        claims.put("userdata", gson.toJson(responseModel.getData()));
        String token = CreateJWTToken.getInstance().create(claims);

        NewCookie newCookie = new NewCookie("jwt-token", token, "/", "20.80.120.180", "", -1, false, true);

        return Response.status(200).entity(gson.toJson(responseModel.getData())).cookie(newCookie).build();
    }
}