package com.infybuzz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infybuzz.entity.Address;
import com.infybuzz.repository.AddressRepository;
import com.infybuzz.request.CreateAddressRequest;
import com.infybuzz.response.AddressResponse;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(AddressService.class);

	public AddressResponse createAddress(CreateAddressRequest request) {
		Address address = new Address();
		address.setStreet(request.getStreet());
		address.setCity(request.getCity());

		address = addressRepository.save(address);

		return new AddressResponse(address);
	}

	public AddressResponse getById(long id) {
		LOGGER.info("Inside getById" + id);
		return new AddressResponse(addressRepository.findById(id).get());
	}

}
