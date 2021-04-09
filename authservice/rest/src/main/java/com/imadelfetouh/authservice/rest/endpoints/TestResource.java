package com.imadelfetouh.authservice.rest.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response test() {
        return Response.status(200).entity("hellll").build();
    }
}
