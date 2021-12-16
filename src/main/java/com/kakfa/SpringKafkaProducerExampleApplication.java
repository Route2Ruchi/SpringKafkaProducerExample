package com.kakfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.kafka" })
@SpringBootApplication
public class SpringKafkaProducerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaProducerExampleApplication.class, args);
	}

}
