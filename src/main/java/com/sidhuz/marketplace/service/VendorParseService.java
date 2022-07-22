package com.sidhuz.marketplace.service;

import com.google.gson.Gson;
import com.sidhuz.marketplace.model.Vendor;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VendorParseService {

    public Vendor parse(String message) {
        Gson gson = new Gson();
        return gson.fromJson(message, Vendor.class);
    }

    public Vendor parse_old(String message) {
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
                    break;
            }
        }
        return vendor;
    }
}
