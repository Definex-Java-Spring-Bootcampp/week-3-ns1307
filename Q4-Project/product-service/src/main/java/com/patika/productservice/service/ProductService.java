package com.patika.productservice.service;

import com.patika.productservice.model.Product;
import com.patika.productservice.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository = new ProductRepository();

    public Product addNewProduct(Product product) {
        return productRepository.addNewProduct(product);
    }

    public List<Product> getAll() {
        return productRepository.getProductList();
    }

    public Optional<Product> getByID(int id) {
        return productRepository.findProductById(id);
    }
}
