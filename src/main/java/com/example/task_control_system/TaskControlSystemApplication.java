package com.example.task_control_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.task_control_system")
public class TaskControlSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskControlSystemApplication.class, args);
	}

}
