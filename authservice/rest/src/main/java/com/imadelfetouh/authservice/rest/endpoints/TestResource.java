package com.imadelfetouh.authservice.rest.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

@Path("/test")
public class TestResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response test() {
        return Response.status(200).entity("test123").build();
    }

    @GET
    @Path("/env")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getEnv() {

        ProcessBuilder processBuilder = new ProcessBuilder();
        Map<String, String> map = processBuilder.environment();
        map.put("imad", "imad1223");
        String env = System.getenv("imad");
        //processBuilder.start();

        return Response.status(200).entity(env).build();
    }

}
