package com.example.property_extender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PropertyExtenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyExtenderApplication.class, args);
	}

}
