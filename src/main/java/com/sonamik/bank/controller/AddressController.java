package com.sonamik.bank.controller;


import com.sonamik.bank.entity.Address;
import com.sonamik.bank.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/address")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAddress(@RequestBody Address address) {
        addressService.createAddress(address);
    }

    @DeleteMapping("/address/delete/{id}")
    public void deleteAddress(@PathVariable("id") Long id) {
        addressService.deleteAddress(id);
    }

    @PutMapping("/address/update/{id}")
    public void updateAddress(@PathVariable("id") Long id, @RequestBody Address address) {
        addressService.updateAddress(id, address);
    }
}
