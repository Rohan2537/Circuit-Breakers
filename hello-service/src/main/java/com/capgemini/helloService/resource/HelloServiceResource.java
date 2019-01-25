package com.capgemini.helloService.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/hello")
public class HelloServiceResource {

	@GetMapping
	public String getName()
	{
		return "Hello World !!!";
	}
}
