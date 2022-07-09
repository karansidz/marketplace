package com.sidhuz.marketplace.model;

import lombok.Data;

import java.util.List;
@Data
public class Product {
    private String productId;
    private String productName;
    private String productDescription;
    private String vendorId;
    private String vendorName;
    private String currency;
    private int price;
    private Inventory inventory;
    private List<Image> productImages;
}
