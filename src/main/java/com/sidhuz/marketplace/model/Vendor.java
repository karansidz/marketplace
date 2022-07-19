package com.sidhuz.marketplace.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="Vendor")
public class Vendor {
    @Id
    private String vendorId;
    private String vendorName;
    private String messageType;
    private double vendorRating;
}
