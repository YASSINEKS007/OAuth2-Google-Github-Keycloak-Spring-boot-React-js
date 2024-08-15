package me.projects.backend.web;

import lombok.AllArgsConstructor;
import me.projects.backend.entities.Customer;
import me.projects.backend.models.Product;
import me.projects.backend.services.CustomerService;
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
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("/add-product")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @DeleteMapping("/delete-customer/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/products")
    @PreAuthorize("hasAuthority('USER')")
    public List<Product> getAllProducts() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
        DefaultOidcUser defaultOidcUser = (DefaultOidcUser) oAuth2AuthenticationToken.getPrincipal();
        String jwtTokenValue = defaultOidcUser.getIdToken().getTokenValue();
        RestClient restClient = RestClient.create("http://localhost:8001");
        List<Product> products = restClient.get().uri("/products").headers(header -> header.set(HttpHeaders.AUTHORIZATION, "Bearer " + jwtTokenValue)).retrieve().body(new ParameterizedTypeReference<>() {
        });
        return products;
    }
}
