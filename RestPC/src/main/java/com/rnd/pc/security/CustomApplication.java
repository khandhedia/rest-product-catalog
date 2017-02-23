package com.rnd.pc.security;

import org.glassfish.jersey.server.ResourceConfig;

public class CustomApplication extends ResourceConfig{
	
	public CustomApplication() {
	 
		packages("com.rnd.pc");
		register(AuthenticationFilter.class);
	}

}
