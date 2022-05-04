package io.github.mateusz00.interviewtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class InterviewTaskApplication {
	public static void main(String[] args) {
		SpringApplication.run(InterviewTaskApplication.class, args);
	}
}
