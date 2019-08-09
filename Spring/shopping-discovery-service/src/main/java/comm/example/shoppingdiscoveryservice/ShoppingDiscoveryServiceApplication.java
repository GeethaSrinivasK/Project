package comm.example.shoppingdiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableEurekaServer

public class ShoppingDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingDiscoveryServiceApplication.class, args);
	}

}
