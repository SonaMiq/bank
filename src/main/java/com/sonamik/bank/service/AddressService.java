package com.sonamik.bank.service;

import com.sonamik.bank.entity.Address;
import com.sonamik.bank.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;

    public void createAddress(Address address) {
        addressRepo.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepo.delete(addressRepo.findById(id).get());
    }

    public void updateAddress(Long id, Address address){
        Address find = addressRepo.findById(id).get();
       // find.setCountryCode(address.getCountryCode());
        find.setCity(address.getCity());
        find.setStreet(address.getStreet());
        find.setBuilding(address.getBuilding());
        find.setHome(address.getHome());
        find.setZip(address.getZip());
        addressRepo.save(find);
    }

}
