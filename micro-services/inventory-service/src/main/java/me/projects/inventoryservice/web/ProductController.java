package me.projects.inventoryservice.web;

import lombok.AllArgsConstructor;
import me.projects.inventoryservice.entities.Product;
import me.projects.inventoryservice.services.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        System.out.println(authentication.getPrincipal());
        return productService.getAllProducts();
    }
}











