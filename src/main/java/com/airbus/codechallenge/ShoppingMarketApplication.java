package com.airbus.codechallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = HypermediaAutoConfiguration.class)
public class ShoppingMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingMarketApplication.class, args);
	}

}
