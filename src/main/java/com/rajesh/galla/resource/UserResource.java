package com.rajesh.galla.resource;

import com.rajesh.galla.bo.UserDetailsBO;
import com.rajesh.galla.entity.SignUpResponse;
import com.rajesh.galla.entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

@Component
@Path("/users")
public class UserResource {

    public Logger logger = Logger.getLogger("User Resource");

    @Autowired
    private UserDetailsBO userDetailsBO;

    public UserResource() {
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public SignUpResponse saveUser(UserDetails userDetails) {

        logger.info("save user method reached");
        logger.info(userDetails.toString());
        SignUpResponse signUpResponse = userDetailsBO.saveUser(userDetails);
        return signUpResponse;
    }

    @GET
    public String checkStatus() {

        return "It works";
    }
}
