package dev.artsman.poc.hexagonal.application.core.usecase;

import dev.artsman.poc.hexagonal.application.core.domain.Customer;
import dev.artsman.poc.hexagonal.application.port.outbound.FindAddressByZipCodeOutputPort;
import dev.artsman.poc.hexagonal.application.port.outbound.InsertCustomerOutputPort;

public class InsertCustomerUseCase {
	private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
	private final InsertCustomerOutputPort insertCustomerOutputPort;

	public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort) {
		this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
		this.insertCustomerOutputPort = insertCustomerOutputPort;
	}

	public void insert(Customer customer, String zipCode) {
		var address = findAddressByZipCodeOutputPort.find(zipCode);
		customer.setAddress(address);

		insertCustomerOutputPort.insert(customer);
	}
}
