package com.sidhuz.marketplace.service;

import com.sidhuz.marketplace.model.Product;
import com.sidhuz.marketplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductParseService productParseService;

    @Autowired
    private ProductRepository productRepository;

    public Product save (String productId, String vendorId, String message) {
        Product product = productParseService.parse(vendorId, message);
        if (validate(productId, vendorId, product)) {
            productRepository.save(product);
            return product;
        } else {
            // TODO throw some exception
        }
        return null;
    }

    public Product get (String productId, String vendorId) {
        String id = productId + ":" + vendorId;
        Optional<Product> dbProduct = productRepository.findById(id);
        if (dbProduct.isPresent()) {
            return dbProduct.get();
        } else {
            //TODO: throw an exception if object isn't there
            return null;
        }
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public List<Product> getVendorProducts(String vendorId) {
        return productRepository.findAllByVendorId(vendorId);
    }

    private boolean validate (String productId, String vendorId, Product product) {
        if (productId.equals(product.getProductId()) && vendorId.equals(product.getVendorId())) {
            return true;
        }
        return false;
    }

}
