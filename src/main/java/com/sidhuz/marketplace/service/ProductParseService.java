package com.sidhuz.marketplace.service;

import com.sidhuz.marketplace.model.Product;
import com.sidhuz.marketplace.util.ProductUtility;
import org.springframework.stereotype.Service;

@Service
public class ProductParseService {

    public Product parse (String vendorId, String message) {
        // TODO
        switch (vendorId) {
            case "V234567":
                return parseType2Json(message);
            case "V456789":
            case "V145678":
                return parseType1Xml(message);
            default:
                return parseType1Json(message);
        }
    }

    private Product parseType1Json (String message) {
        // TODO
        return ProductUtility.createDummyProduct();
    }

    private Product parseType2Json (String message) {
        // TODO
        return ProductUtility.createDummyProduct();
    }

    private Product parseType1Xml (String message) {
        // TODO
        return ProductUtility.createDummyProduct();
    }


}
