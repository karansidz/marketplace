package com.sidhuz.marketplace.service;

import com.sidhuz.marketplace.model.Image;
import com.sidhuz.marketplace.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductParseService {

    @Autowired
    private VendorService vendorService;

    public Product parse(String vendorId, String message) {
        switch (vendorService.get(vendorId).getMessageType()) {
            case "Type2Json":
                return parseType2Json(message);
            case "Type1Xml":
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
                case "price":
                    product.setPrice((Double) entry.getValue());
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
        product.generateId();
        return product;
    }

    private Product parseType2Json(String message) {
        // TODO
        JsonParser parser = JsonParserFactory.getJsonParser();
        Map<String, Object> map = parser.parseMap(message);
        Product product = new Product();

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            switch (entry.getKey()) {
                case "itemId":
                    product.setProductId((String) entry.getValue());
                    break;
                case "itemName":
                    product.setProductName(((String) entry.getValue()));
                    break;
                case "itemDescription":
                    product.setProductDescription(((String) entry.getValue()));
                    break;
                case "sellerId":
                    product.setVendorId((String) entry.getValue());
                    break;
                case "price":
                    product.setPrice((Double) entry.getValue());
                    break;
                case "currency":
                    product.setCurrency(((String) entry.getValue()));
                    break;
                case "itemsInStock":
                    product.setStockOnHand((Integer) entry.getValue());
                    break;
                case "images":
                    product.setProductImages(parseType2Images((List<Object>) entry.getValue()));
                    break;
                default:
                    // TODO: handle case where you get a key that is not mappable
                    break;
            }
        }

        //TODO parse JSON message and assign to correct product attributes using set methods.
        product.generateId();
        return product;

    }

    private Product parseType1Xml(String message) {
        // TODO
        return new Product();
    }

    private List<Image> parseType1Images(List<Object> imageDataList) {
        List<Image> imageList = new ArrayList<>();
        for (Object imageData: imageDataList) {
            Map<String, Object> dataMap = (HashMap) imageData;
            Image image = new Image();
            for(Map.Entry<String, Object> entry : dataMap.entrySet()) {
                switch(entry.getKey()) {
                    case "imageURL" :
                        image.setUrl((String) entry.getValue());
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

    private List<Image> parseType2Images(List<Object> imageDataList) {
        List<Image> imageList = new ArrayList<>();
        for (Object imageData: imageDataList) {
            Map<String, Object> dataMap = (HashMap) imageData;
            Image image = new Image();
            for(Map.Entry<String, Object> entry : dataMap.entrySet()) {
                switch(entry.getKey()) {
                    case "imageURL" :
                        image.setUrl((String) entry.getValue());
                        break;
                    case "imageSequenceNumber" :
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
