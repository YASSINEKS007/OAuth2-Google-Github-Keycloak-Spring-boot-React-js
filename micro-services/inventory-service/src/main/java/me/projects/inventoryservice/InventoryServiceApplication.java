package me.projects.inventoryservice;

import me.projects.inventoryservice.entities.Product;
import me.projects.inventoryservice.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductService productService) {
        return args -> {
            productService.addProduct(Product.builder()
                    .name("Product 1")
                    .price(1000.0)
                    .quantity(10)
                    .build());

            productService.addProduct(Product.builder()
                    .name("Product 2")
                    .price(2000.0)
                    .quantity(20)
                    .build());

            productService.addProduct(Product.builder()
                    .name("Product 3")
                    .price(3000.0)
                    .quantity(30)
                    .build());
        };
    }
}
