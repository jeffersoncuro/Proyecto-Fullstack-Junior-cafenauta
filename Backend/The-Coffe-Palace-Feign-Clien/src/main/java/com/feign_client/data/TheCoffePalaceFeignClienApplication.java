package com.feign_client.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TheCoffePalaceFeignClienApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheCoffePalaceFeignClienApplication.class, args);
	}

}
