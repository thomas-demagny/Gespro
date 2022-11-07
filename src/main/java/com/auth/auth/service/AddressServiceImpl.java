package com.auth.auth.service;


import com.auth.auth.entity.Address;
import com.auth.auth.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {


    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        super();
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getById(int id) {
        return addressRepository.findByIdOrThrow(id);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void delete(int id) {
        Address address = addressRepository.findByIdOrThrow(id);
        addressRepository.delete(address);

    }

    @Override
    public Address getAddressByCountryAndZipCode(String country, int zipCode) {
        return null;
    }


}