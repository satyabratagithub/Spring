package com.cassandra.spring.jersey.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.cassandra.spring.resource.EmployeeResource;

@Component
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(EmployeeResource.class);
	}
}
