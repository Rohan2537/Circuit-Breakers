package com.capgemini.websiteService.websiteController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
@EnableCircuitBreaker
public class websiteController {

	@Autowired
	private RestTemplate template;

	@RequestMapping("/")
	@HystrixCommand(fallbackMethod="reliable")
	public ModelAndView home() {
		String responseOne = template.getForObject("http://localhost:9090/hello", String.class);
		return new ModelAndView("hello", "message", responseOne);
	}
	public  ModelAndView reliable() {
		String input= "Good Morning... :)";
	     return new ModelAndView("hello", "message", input);
	  }
}
