package com.sidhuz.marketplace.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/consume")
public class ConsumeController {

    @GetMapping("/hello-world/{vendor-name}")
    public ResponseEntity<String> sayHelloWorld(@PathVariable("vendor-name") String vendorName) {
        return new ResponseEntity<>("Hello " + vendorName + LocalDateTime.now(), HttpStatus.OK);
    }

    @GetMapping("/show-product/{vendor-name}/{product-name}")
    public ResponseEntity<String> giveProduct(@PathVariable("vendor-name") String vendorName, @PathVariable("product-name") String productName) {
        return new ResponseEntity<String>("The product is "  + productName + " and is sold by " + vendorName, HttpStatus.OK);
    }

    @PostMapping("/add-product/{product-name}")
    public ResponseEntity<String> addProduct(@RequestBody String newProduct) {
        return new ResponseEntity<String>("Product is " + newProduct, HttpStatus.CREATED);
    }
}
