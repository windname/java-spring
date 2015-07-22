package com.vg.spring.mvc.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestExample {

	/**
	 * http://localhost:8080/sport?name=basket
	 * {"sportName":"basket","sportId":0}
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/sport")
	public SportDto getSport(@RequestParam(value = "name", defaultValue = "Footbal") String name) {
		SportDto sport = new SportDto();
		sport.setSportName(name);
		return sport;
	}

	/**
	 * http://localhost:8080/feed/1 result: {"sportName":null,"sportId":1}
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/feed/{id}")
	public SportDto getFeed(@PathVariable int id) {
		SportDto sport = new SportDto();
		sport.setSportId(id);
		return sport;
	}
}
