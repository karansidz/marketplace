package com.sidhuz.marketplace.service;

import com.sidhuz.marketplace.model.Image;
import com.sidhuz.marketplace.model.Product;
import com.sidhuz.marketplace.util.ProductUtility;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductParseService {

    public Product parse(String vendorId, String message) {
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

    private Product parseType1Json(String message) {
        // TODO
        JsonParser parser = JsonParserFactory.getJsonParser();
        Map<String, Object> map = parser.parseMap(message);
        Product product = new Product();

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            switch (entry.getKey()) {
                case "productId":
                    product.setProductId((String) entry.getValue());
                    break;
                case "productName":
                    product.setProductName(((String) entry.getValue()));
                    break;
                case "productDescription":
                    product.setProductDescription(((String) entry.getValue()));
                    break;
                case "vendorId":
                    product.setVendorId((String) entry.getValue());
                    break;
                case "vendorName":
                    product.setVendorName(((String) entry.getValue()));
                    break;
                case "price":
                    product.setPrice((Integer) entry.getValue());
                    break;
                case "currency":
                    product.setCurrency(((String) entry.getValue()));
                    break;
                case "stockOnHand":
                    product.setStockOnHand((Integer) entry.getValue());
                    break;
                case "images":
                    product.setProductImages(parseType1Images((List<Object>) entry.getValue()));
                    break;
                default:
                    // TODO: handle case where you get a key that is not mappable
                    break;
            }
        }

        //TODO parse JSON message and assign to correct product attributes using set methods.
        return product;
    }

    private Product parseType2Json(String message) {
        // TODO
        return ProductUtility.createDummyProduct();
    }

    private Product parseType1Xml(String message) {
        // TODO
        return ProductUtility.createDummyProduct();
    }

    private List<Image> parseType1Images(List<Object> imageDataList) {
        List<Image> imageList = new ArrayList<>();
        for (Object imageData: imageDataList) {
            Map<String, Object> dataMap = (HashMap) imageData;
            Image image = new Image();
            for(Map.Entry<String, Object> entry : dataMap.entrySet()) {
                switch(entry.getKey()) {
                    case "imageURL" :
                        image.setImageUrl((String) entry.getValue());
                        break;
                    case "sequenceNumber" :
                        image.setSeqNbr((Integer) entry.getValue());
                        break;
                    default:
                        break;
                }
            }
            imageList.add(image);
        }
        return imageList;
    }

}
