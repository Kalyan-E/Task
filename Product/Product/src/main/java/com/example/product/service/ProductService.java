package com.example.product.service;

import com.example.product.model.ProductModel;
import com.example.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;


    public void addProduct(ProductModel productmodel) {
        productRepository.save(productmodel);
    }

    public ProductModel updateProduct(ProductModel productModel) {
            ProductModel existingProduct = productRepository.findById(productModel.getId()).get();
            existingProduct.setProductName(productModel.getProductName());
            existingProduct.setStock(productModel.getStock());
            existingProduct.setPrice(productModel.getPrice());
            ProductModel updateProduct = productRepository.save(existingProduct);
            return updateProduct;
        }


    public void deleteProduct(Long productId) {
      productRepository.deleteById(productId);
    }
}

