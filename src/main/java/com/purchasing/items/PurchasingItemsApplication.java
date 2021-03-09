package com.purchasing.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.purchasing.items"})
public class PurchasingItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchasingItemsApplication.class, args);
	}

}
