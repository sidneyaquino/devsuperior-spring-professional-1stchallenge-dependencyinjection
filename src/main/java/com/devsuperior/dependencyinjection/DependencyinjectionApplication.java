package com.devsuperior.dependencyinjection;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.dependencyinjection.entities.Order;
import com.devsuperior.dependencyinjection.services.OrderService;

@SpringBootApplication
public class DependencyinjectionApplication implements CommandLineRunner{
	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(DependencyinjectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		char cn;
		do {
			System.out.println();
			System.out.println("DATA ORDER:");
			System.out.println("Enter the order code:	");
			Integer code = sc.nextInt();
			System.out.println("Enter the basic value: ");
			double basic = sc.nextDouble();
			System.out.println("Enter with percentage discount: ");
			double discount = sc.nextDouble();
	
			double total = orderService.total(new Order(code, basic, discount));
			System.out.println("Order code : " + code);
			System.out.printf("Total value: %.2f%n", total);

			System.out.println();
			System.out.println("Another order? (Entry 'y' to continue): ");
			cn = sc.next().toUpperCase().charAt(0);
		} while (cn == 'Y');

		System.err.println("End of the program");
		sc.close();
	}
}