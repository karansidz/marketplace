package com.sidhuz.marketplace.repository;

import com.sidhuz.marketplace.model.Product;
import com.sidhuz.marketplace.util.ProductUtility;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class ProductRepository {

    public void save (Product product) {
        // TODO
        System.out.println("Saving object to the database");
    }

    public Product get (String productId, String vendorId) {
        return ProductUtility.createDummyProduct();
    }
}
