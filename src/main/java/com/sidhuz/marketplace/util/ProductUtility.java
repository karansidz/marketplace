package com.sidhuz.marketplace.util;

import com.sidhuz.marketplace.model.Product;

public class ProductUtility {

    public static Product createDummyProduct () {
        Product product = new Product();
        product.setProductId("PXXXXXXX");
        product.setProductName("TEST PRODUCT");
        return product;
    }
}
