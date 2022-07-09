package com.sidhuz.marketplace.model;

import lombok.Data;

@Data
public class Inventory {
    private String productId;
    private String vendorId;
    int stockOnHand;
}
