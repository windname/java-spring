package com.vg.spring.mvc.jsp;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}

	@RequestMapping("/foo")
	public String foo(Map<String, Object> model) {
		throw new RuntimeException("Foo");
	}

	@RequestMapping("/simple")
	@ResponseBody
	public String helloWorld() {
		return "Simple welcome";
	}

	@RequestMapping(value = "/welcome")
	public ModelAndView getHello() {
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("msg", "hello world");

		return model;
	}

}

// }
