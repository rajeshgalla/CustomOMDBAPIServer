package com.rajesh.galla.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class WelcomeResource {

    @GET
    public String welcome() {

        return "Welcome to my page";
    }
}
