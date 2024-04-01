package com.patika.productservice.repo;

import com.patika.productservice.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private int lastProductID=0;
    private List<Product> productList = new ArrayList<>();



    public List<Product> getProductList() {
        return productList;
    }

    public Product addNewProduct(Product product) {
        product.setId(lastProductID);
        lastProductID++;
        productList.add(product);
        return product;
    }

    public Optional<Product> findProductById(int id) {
        return productList.stream()
                .filter(product -> product.getId() == id)
                .findFirst();
    }
}
