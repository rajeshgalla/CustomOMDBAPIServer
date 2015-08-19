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

    @Autowired
    private UserDetailsBO userDetailsBO;

    public UserResource() {
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public SignUpResponse saveUser(UserDetails userDetails) {

        System.out.println(userDetails.toString());
        SignUpResponse signUpResponse = userDetailsBO.saveUser(userDetails);
        return signUpResponse;
    }
}
