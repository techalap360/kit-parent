package com.kit.bo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
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
public class BOApplication {

	public static void main(String[] args) {
		SpringApplication.run(BOApplication.class, args);
	}
}
