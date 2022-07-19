package com.sidhuz.marketplace.service;

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
        if (validate(vendorId, vendor)) {
            vendorRepository.save(vendor);
            return vendor;
        } else {
            // TODO throw some exception
        }
        return null;
    }

    public Vendor get (String vendorId) {
        Optional<Vendor> dbVendor = vendorRepository.findById(vendorId);
        if (dbVendor.isPresent()) {
            return dbVendor.get();
        } else {
            //TODO: throw an exception if object isn't there
            return null;
        }
    }

    public List<Vendor> getAll () {
        return vendorRepository.findAll();
    }

    private boolean validate (String vendorId, Vendor vendor) {
        if (vendor.getVendorId().equals(vendorId)) {
            return true;
        }
        return false;
    }

}
