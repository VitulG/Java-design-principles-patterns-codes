package com.example.personal;

import com.example.personal.command.CommandExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseappApplication.class, args);

		CommandExecutor executor = new CommandExecutor();
		Scanner sc = new Scanner(System.in);

		while (true) {
			String input = sc.next();
			executor.executeCommand(input);
		}
	}

}
