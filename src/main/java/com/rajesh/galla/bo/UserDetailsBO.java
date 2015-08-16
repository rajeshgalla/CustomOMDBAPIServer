package com.rajesh.galla.bo;

import com.rajesh.galla.entity.SignUpResponse;
import com.rajesh.galla.entity.UserDetails;

public interface UserDetailsBO {

    SignUpResponse saveUser(UserDetails userDetails);
}
