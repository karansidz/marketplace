package com.sidhuz.marketplace.service;

import com.sidhuz.marketplace.exception.MarketplaceException;
import com.sidhuz.marketplace.model.Product;
import com.sidhuz.marketplace.repository.ProductRepository;
import com.sidhuz.marketplace.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private ProductParseService productParseService;

    @Autowired
    private ProductRepository productRepository;

    public Product save (String productId, String vendorId, String message) {
        Product product = productParseService.parse(vendorId, message);
        if (validate(productId, vendorId, product) && validateVendor(vendorId)) {
            productRepository.save(product);
            return product;
        }
        return null;
    }

    public Product get (String productId, String vendorId) {
        String id = productId + ":" + vendorId;
        Optional<Product> dbProduct = productRepository.findById(id);
        if (dbProduct.isPresent()) {
            return dbProduct.get();
        } else {
            throw new MarketplaceException("Product does not exist in the database");
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
        throw new MarketplaceException("Failed to validate URL ids with actual product/vendor ids");
    }

    private boolean validateVendor (String vendorId) {
        if (vendorRepository.findById(vendorId).isPresent()) {
            return true;
        }
        throw new MarketplaceException("Vendor is not in the database.");
    }
}
