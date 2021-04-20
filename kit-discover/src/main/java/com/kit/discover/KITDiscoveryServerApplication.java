package com.kit.discover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Zubayer Ahamed
 * @since Apr 20, 2021
 */
@SpringBootApplication
@EnableEurekaServer
public class KITDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KITDiscoveryServerApplication.class, args);
	}
}
