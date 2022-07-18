package com.sidhuz.marketplace.repository;

import com.sidhuz.marketplace.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    // Reference code on how to query using @query annotation. Using DSL findBy methods are more flexible
    // @Query("{vendorId :?0}")
    // List<Product> getProductsByVendor(String vendorId);

    // DSL Query
    List<Product> findAllByVendorId(String vendorId);

}
