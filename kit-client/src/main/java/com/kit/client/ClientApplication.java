package com.kit.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Zubayer Ahamed
 * @since Apr 18, 2021
 */
@SpringBootApplication
@EntityScan(basePackages = "com.kit.*")
@ComponentScan(basePackages = "com.kit.*")
@EnableJpaRepositories(basePackages = "com.kit.*")
//@PropertySources({
//	@PropertySource("classpath:kit.properties")
//})
@EnableEurekaClient
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
}
