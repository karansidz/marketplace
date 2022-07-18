package com.sidhuz.marketplace.util;

import com.sidhuz.marketplace.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductUtility {

    public static final Map<String, String> vendorParseMap;

    static {
        vendorParseMap = new HashMap<>();
        vendorParseMap.put("V-KOOKABURRA", "Type1Json");
        vendorParseMap.put("V-SAMSUNG", "Type2Json");
        vendorParseMap.put("0003", "Type1Json");
        vendorParseMap.put("0004", "Type1Xml");
    }

    public static String getVendorParseType (String vendorId) {
        return vendorParseMap.get(vendorId);
    }

}
