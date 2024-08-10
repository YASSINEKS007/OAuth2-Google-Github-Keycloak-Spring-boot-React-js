package me.projects.backend;

import me.projects.backend.entities.Product;
import me.projects.backend.services.ProductService;
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
    public CommandLineRunner commandLineRunner(ProductService productService) {
        return args -> {
            productService.createProduct(Product.builder()
                    .name("Product 1")
                    .description("Description of Product 1")
                    .price(1000.0)
                    .build());
            productService.createProduct(Product.builder()
                    .name("Product 2")
                    .description("Description of Product 2")
                    .price(2000.0)
                    .build());
            productService.createProduct(Product.builder()
                    .name("Product 3")
                    .description("Description of Product 3")
                    .price(3000.0)
                    .build());
        };
    }

}
