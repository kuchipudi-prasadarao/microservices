package com.kuchipudi.microservices.spring_cloud_client_config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringCloudClientConfigController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		
		Limits limits = new Limits(configuration.getMinimum(), 
				configuration.getMaximum());
		
		return limits;
		
	}

}
