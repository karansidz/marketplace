package com.sidhuz.marketplace.service;

import com.sidhuz.marketplace.model.Vendor;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VendorParseService {

    public Vendor parse(String message) {
        JsonParser parser = JsonParserFactory.getJsonParser();
        Map<String, Object> map = parser.parseMap(message);
        Vendor vendor = new Vendor();

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            switch (entry.getKey()) {
                case "vendorId":
                    vendor.setVendorId((String) entry.getValue());
                    break;
                case "vendorName":
                    vendor.setVendorName(((String) entry.getValue()));
                    break;
                case "vendorRating":
                    vendor.setVendorRating((Double) entry.getValue());
                    break;
                case "messageType":
                    vendor.setMessageType((String) entry.getValue());
                    break;
                default:
                    // TODO: handle case where you get a key that is not mappable
                    break;
            }
        }
        return vendor;
    }
}
