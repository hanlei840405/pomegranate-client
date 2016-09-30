package com.fruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"main-data-center-client-provider.xml","main-data-center-client-consumer.xml"})
@EnableCaching
public class PomegranateClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PomegranateClientApplication.class, args);
	}
}
