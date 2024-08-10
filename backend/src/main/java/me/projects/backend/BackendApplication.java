package me.projects.backend;


import me.projects.backend.entities.Customer;
import me.projects.backend.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerService customerService) {
        return args -> {
            customerService.createCustomer(Customer.builder()
                    .name("Customer 1")
                    .email("customer1@test.com")
                    .build());
            customerService.createCustomer(Customer.builder()
                    .name("Customer 2")
                    .email("customer2@test.com")
                    .build());
            customerService.createCustomer(Customer.builder()
                    .name("Customer 3")
                    .email("customer3@test.com")
                    .build());
        };
    }

}
