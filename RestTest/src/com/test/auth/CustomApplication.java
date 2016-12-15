package com.test.auth;
 

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

 
public class CustomApplication extends ResourceConfig 
{
    public CustomApplication() 
    {
        packages("com.test");    
        register(LoggingFeature.class);
        //Register Auth Filter here
        register(AuthenticationFilter.class);
    }
}