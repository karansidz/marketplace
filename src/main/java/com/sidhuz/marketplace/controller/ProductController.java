package com.sidhuz.marketplace.controller;

import com.sidhuz.marketplace.model.Product;
import com.sidhuz.marketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // TODO create post functionality
    @PostMapping("/save-product/{vendor-id}/{product-id}")
    public ResponseEntity<Product> saveProduct(@PathVariable("vendor-id") String vendorId, @PathVariable("product-id") String productId, @RequestBody String message) {
        Product product = productService.save(productId, vendorId, message);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    // TODO create get calls
}
