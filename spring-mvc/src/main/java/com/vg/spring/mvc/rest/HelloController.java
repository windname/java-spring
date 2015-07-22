package com.vg.spring.mvc.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vladimir Grigoriev (vladimir.grigoriev@codefactorygroup.com)
 * 
 */
@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}