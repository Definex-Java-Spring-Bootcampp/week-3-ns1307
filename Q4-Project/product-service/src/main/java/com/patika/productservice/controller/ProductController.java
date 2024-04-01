package com.patika.productservice.controller;

import com.patika.productservice.model.Product;
import com.patika.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products/")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;


    @PostMapping("new-product")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product createdProduct = productService.addNewProduct(product);
        return ResponseEntity.ok(createdProduct);
    }



    @GetMapping("{productID}")
    public ResponseEntity<Product> getByID(@PathVariable("productID") int productID) {

        Optional<Product> foundProduct= productService.getByID(productID);

        return foundProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("all")
    @ResponseStatus(HttpStatus.CREATED)
    protected List<Product> getAllInvoices() {
        return productService.getAll();
    }








}
