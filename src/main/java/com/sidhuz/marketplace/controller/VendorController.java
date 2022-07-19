package com.sidhuz.marketplace.controller;

import com.sidhuz.marketplace.model.Product;
import com.sidhuz.marketplace.model.Vendor;
import com.sidhuz.marketplace.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping("/save-vendor/{vendor-id}")
    public ResponseEntity<Vendor> saveVendor(@PathVariable("vendor-id") String vendorId, @RequestBody String message) {
        Vendor vendor = vendorService.save(vendorId, message);
        return new ResponseEntity<Vendor>(vendor, HttpStatus.CREATED);
    }

    @GetMapping("/show-vendor/{vendor-id}")
    public ResponseEntity<Vendor> showVendor(@PathVariable("vendor-id") String vendorId) {
        Vendor vendor = vendorService.get(vendorId);
        return new ResponseEntity<Vendor>(vendor, HttpStatus.OK);
    }

    @GetMapping("/show-all")
    public ResponseEntity<List<Vendor>> showAll() {
        List<Vendor> vendorList = vendorService.getAll();
        return new ResponseEntity<List<Vendor>>(vendorList, HttpStatus.OK);
    }



}
