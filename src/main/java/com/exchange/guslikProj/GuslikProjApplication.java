package com.exchange.guslikProj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.exchange.guslikProj")
public class GuslikProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuslikProjApplication.class, args);
	}

}
