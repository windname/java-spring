package com.vg.spring.mvc;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author Vladimir Grigoriev (vladimir.grigoriev@codefactorygroup.com)
 * 
 */
@SpringBootApplication
public class ApplicationMvcRest {

	/**
	 * From eclipse just need to run this class as java application!
	 * from command line something like : mvn package && java -jar target/gs-spring-boot-0.1.0.jar
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ApplicationMvcRest.class, args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}

}