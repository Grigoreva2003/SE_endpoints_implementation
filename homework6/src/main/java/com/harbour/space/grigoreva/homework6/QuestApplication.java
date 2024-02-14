package com.harbour.space.grigoreva.homework6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class QuestApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(QuestApplication.class, args);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
