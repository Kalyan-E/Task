package com.example.product.controller;


import com.example.product.model.ProductModel;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private final ProductService productService;
    @Autowired
    private  final ProductRepository productRepository;

    @PostMapping
    public ResponseEntity addProducts(@RequestBody ProductModel productModel)
    {
        productService.addProduct(productModel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public List<ProductModel> getAllEmployee()
    {
        return (List<ProductModel>) productRepository.findAll();
    }
    @PutMapping("{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable("id") Long userId,
                                           @RequestBody ProductModel productModel){
        productModel.setId(userId);
        ProductModel updatedProduct = productService.updateProduct(productModel);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
