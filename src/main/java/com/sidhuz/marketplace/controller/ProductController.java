package com.sidhuz.marketplace.controller;

import com.sidhuz.marketplace.model.Product;
import com.sidhuz.marketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // TODO create post functionality
    @PostMapping("/save-product/{product-id}/{vendor-id}")
    public ResponseEntity<Product> saveProduct(@PathVariable("vendor-id") String vendorId, @PathVariable("product-id") String productId, @RequestBody String message) {
        Product product = productService.save(productId, vendorId, message);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    // TODO create get calls
    @CrossOrigin
    @GetMapping("/show-product/{product-id}/{vendor-id}")
    public ResponseEntity<Product> showProduct(@PathVariable("vendor-id") String vendorId, @PathVariable("product-id") String productId) {
        Product product = productService.get(productId, vendorId);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @GetMapping("/show-vendor-products/{vendor-id}")
    public ResponseEntity<List<Product>> showVendorProducts(@PathVariable("vendor-id") String vendorId) {
        List<Product> productList = productService.getVendorProducts(vendorId);
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }

    @GetMapping("/show-all")
    public ResponseEntity<List<Product>> showAll() {
        List<Product> productList = productService.getAll();
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }


}
