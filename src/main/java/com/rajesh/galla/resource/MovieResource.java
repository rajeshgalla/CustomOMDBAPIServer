package com.rajesh.galla.resource;

import com.rajesh.galla.bo.MovieBO;
import com.rajesh.galla.dao.MovieDAO;
import org.glassfish.jersey.server.Uri;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Calendar;
import java.util.Locale;

@Component
@Path("/movies")
public class MovieResource {

    @Autowired
    MovieBO movieBO;

    @GET
    @Path("/{movie-Name}")
    public Response getMovie(@PathParam("movie-Name") String movieName,@QueryParam("token") String token) {

        String json = movieBO.searchForMovie(movieName, token, Calendar.getInstance(Locale.CANADA));
        return Response.ok(json,MediaType.APPLICATION_JSON).build();
    }
}