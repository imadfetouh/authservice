package com.imadelfetouh.authservice.rest.endpoints;

import com.google.gson.Gson;
import com.imadelfetouh.authservice.dalinterface.SignInDal;
import com.imadelfetouh.authservice.factory.Factory;
import com.imadelfetouh.authservice.factory.signininstance.CreateSignInInstance;
import com.imadelfetouh.authservice.model.jwt.UserData;
import com.imadelfetouh.authservice.model.response.ResponseModel;
import com.imadelfetouh.authservice.model.response.ResponseType;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/signin")
public class SignInResource {

    private SignInDal signInDal;

    public SignInResource() {
        this.signInDal = (SignInDal) Factory.getInstance().buildInstance(new CreateSignInInstance());
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response signIn(@FormParam("username") String username, @FormParam("password") String password) {

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

        return Response.status(200).entity(gson.toJson(responseModel.getData())).cookie().build();

    }
}