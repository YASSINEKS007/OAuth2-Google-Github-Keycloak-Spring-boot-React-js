package me.projects.backend.web;

import lombok.AllArgsConstructor;
import me.projects.backend.entities.Product;
import me.projects.backend.services.ProductService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Product> getAllProducts() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        System.out.print("***************************************");
        System.out.println("securityContext: \n" + securityContext);
        System.out.println("***************************************");
        Authentication authentication = securityContext.getAuthentication();
        System.out.println("authentication: \n" + authentication);
        System.out.println("***************************************");
        OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
        DefaultOidcUser defaultOidcUser = (DefaultOidcUser) oAuth2AuthenticationToken.getPrincipal();
        String jwtTokenValue = defaultOidcUser.getIdToken().getTokenValue();
        RestClient restClient = RestClient.create("http://localhost:8090");
        List<Product> products = restClient.get().uri("/products").headers(header -> header.set(HttpHeaders.AUTHORIZATION, "Bearer" + jwtTokenValue)).retrieve().body(new ParameterizedTypeReference<>() {
        });


        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("/delete-product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
