package com.sidhuz.marketplace.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Document(collection="Product")
public class Product {
    @Id
    private String id;
    private String productId;
    private String productName;
    private String productDescription;
    private String vendorId;
    private String currency;
    private double price;
    private int stockOnHand;
    private List<Image> productImages;

    public String generateId() {
        this.id = this.productId + ":" + this.vendorId;
        return this.id;
    }
}
