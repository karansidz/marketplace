package com.sidhuz.marketplace.util;

import com.sidhuz.marketplace.model.Product;

public class ProductUtility {

    public static Product createDummyProduct () {
        Product product = new Product();
        product.setProductId("PXXX");
        product.setVendorId("VXXX");
        product.setProductName("TEST PRODUCT");
        return product;
    }
}
