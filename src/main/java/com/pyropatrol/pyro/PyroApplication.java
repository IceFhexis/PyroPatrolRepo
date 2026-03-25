package com.pyropatrol.pyro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PyroApplication {

	public static void main(String[] args) {
		SpringApplication.run(PyroApplication.class, args);
	}

}
