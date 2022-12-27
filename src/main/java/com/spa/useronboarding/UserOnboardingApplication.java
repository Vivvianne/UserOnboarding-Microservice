package com.spa.useronboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @EntityScan("com.spa.useronboarding.*")
// @EnableJpaRepositories("com.spa.useronboarding.*")
public class UserOnboardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserOnboardingApplication.class, args);
	}

}
