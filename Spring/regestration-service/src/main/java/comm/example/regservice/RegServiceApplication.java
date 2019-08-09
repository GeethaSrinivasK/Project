package comm.example.regservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RegServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegServiceApplication.class, args);
	}
}
