package com.harbour.space.grigoreva.homework6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuestApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(QuestApplication.class, args);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
		}
	}
}
