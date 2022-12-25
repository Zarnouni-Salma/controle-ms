package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication   {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository  ){
		return  args -> {
			for (int i = 1; i < 5; i++) {
				String name = "Customer" + i;
				customerRepository.save(new Customer(null,name,name+"@gmail.com"));
			}
			customerRepository.findAll().forEach(customer -> {
				System.out.println(customer.toString());
			});
		};

	}

}
