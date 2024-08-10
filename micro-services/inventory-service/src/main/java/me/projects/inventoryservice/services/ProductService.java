package me.projects.inventoryservice.services;


import me.projects.inventoryservice.entities.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    Product getProduct(String productId);
    List<Product> getAllProducts();
    void deleteProductById(String productId);

}
