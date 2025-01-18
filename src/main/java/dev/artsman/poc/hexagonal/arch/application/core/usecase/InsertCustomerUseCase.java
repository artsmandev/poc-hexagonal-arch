package dev.artsman.poc.hexagonal.arch.application.core.usecase;

import dev.artsman.poc.hexagonal.arch.application.core.domain.Customer;
import dev.artsman.poc.hexagonal.arch.application.port.outbound.FindAddressByZipCodeOutputPort;
import dev.artsman.poc.hexagonal.arch.application.port.outbound.InsertCustomerOutputPort;
import java.util.UUID;

public class InsertCustomerUseCase {
	private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
	private final InsertCustomerOutputPort insertCustomerOutputPort;

	public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort) {
		this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
		this.insertCustomerOutputPort = insertCustomerOutputPort;
	}

	public void insert(Customer customer, UUID zipCode) {
		var address = findAddressByZipCodeOutputPort.find(zipCode);
		customer.setAddress(address);

		insertCustomerOutputPort.insert(customer);
	}
}
