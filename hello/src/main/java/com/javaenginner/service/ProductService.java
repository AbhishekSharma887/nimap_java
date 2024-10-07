package com.javaenginner.service;
import com.javaenginner.entity.Product;
import com.javaenginner.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(int page) {
        // Implement pagination logic if needed
        return productRepository.findAll(); // Fetch all products
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null); // Fetch product by ID
    }

    public Product createProduct(Product product) {
        return productRepository.save(product); // Save new product
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id);
        if (product != null) {
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            return productRepository.save(product); // Update product
        }
        return null;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id); // Delete product by ID
    }
}
