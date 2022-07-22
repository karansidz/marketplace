package com.sidhuz.marketplace.service;

import com.sidhuz.marketplace.exception.MarketplaceException;
import com.sidhuz.marketplace.model.Vendor;
import com.sidhuz.marketplace.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private VendorParseService vendorParseService;

    public Vendor save (String vendorId, String message) {
        Vendor vendor = vendorParseService.parse(message);
        if (validate(vendorId, vendor) && validateMessageType(vendor.getMessageType())) {
            vendorRepository.save(vendor);
            return vendor;
        }
        return null;
    }

    public Vendor get (String vendorId) {
        Optional<Vendor> dbVendor = vendorRepository.findById(vendorId);
        if (dbVendor.isPresent()) {
            return dbVendor.get();
        } else {
            throw new MarketplaceException("Vendor cannot be found for processing " + vendorId);
        }
    }

    public List<Vendor> getAll () {
        return vendorRepository.findAll();
    }

    private boolean validate (String vendorId, Vendor vendor) {
        if (vendor.getVendorId().equals(vendorId)) {
            return true;
        }
        StringBuilder  stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to validate vendor during the save. ");
        stringBuilder.append("Vendor Id ");
        stringBuilder.append(vendorId);
        throw new MarketplaceException(stringBuilder.toString());
    }

    private boolean validateMessageType (String messageType) {
        if (messageType.equals("Type1Json") || messageType.equals("Type2Json")) {
            return true;
        }
        throw new MarketplaceException("This vendor message type is not supported");
    }

}
