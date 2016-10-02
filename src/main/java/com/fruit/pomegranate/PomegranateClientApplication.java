package com.fruit.pomegranate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.Arrays;

@SpringBootApplication
@ImportResource({"pomegranate-client-provider.xml", "pomegranate-client-consumer.xml"})
@EnableCaching
public class PomegranateClientApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(PomegranateClientApplication.class, args);
		String[] beans = ctx.getBeanDefinitionNames();
		Arrays.sort(beans);
		for (String bean : beans) {
			System.out.println(bean);
		}
	}
}
