package com.andu033.restapi.basiccrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class BasiccrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasiccrudApplication.class, args);
	}

}
