package net.mausberg.myfinancesbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"net.mausberg.authentication_framework_backend", "net.mausberg.myfinancesbackend"})
@EnableJpaRepositories(basePackages = "net.mausberg.myfinancesbackend.repository")
@EntityScan(basePackages = "net.mausberg.myfinancesbackend.model")
public class MyFinancesBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFinancesBackendApplication.class, args);
	}

}
