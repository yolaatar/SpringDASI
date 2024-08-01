package com.helloIftekhar.springJwt.service;

import com.helloIftekhar.springJwt.model.Product;
import com.helloIftekhar.springJwt.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name).orElse(null);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null) ;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public String getDescription(Long id) {
        return productRepository.findById(id).get().getDescription();
    }

    public Integer getStock(Long id) {
        return productRepository.findById(id).get().getStock();
    }
}
