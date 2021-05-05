package com.imadelfetouh.authservice.rest.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/logout")
public class LogoutResource {

    @GET
    public Response logout() {
        NewCookie newCookie = new NewCookie("jwt-token", null, "/", "20.80.120.180", "", 0, false, true);

        return Response.status(200).cookie(newCookie).build();
    }
}
