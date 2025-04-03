package com.kuchipudi.hello.world.hello_world_java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldJavaController {

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
}
