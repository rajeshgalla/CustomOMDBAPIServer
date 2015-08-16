package com.rajesh.galla;

import org.glassfish.jersey.server.ResourceConfig;

public class JerseyResourceInjection extends ResourceConfig{

    public JerseyResourceInjection() {

        System.out.println("JerseyResourceInjection");
        packages("com.rajesh.galla.resource");
    }
}