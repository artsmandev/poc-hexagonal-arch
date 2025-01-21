package dev.artsman.poc.hexagonal.arch.application.core.usecase;

import dev.artsman.poc.hexagonal.arch.application.core.domain.Customer;
import dev.artsman.poc.hexagonal.arch.application.port.inbound.InsertCustomerInputPort;
import dev.artsman.poc.hexagonal.arch.application.port.outbound.FindAddressByZipCodeOutputPort;
import dev.artsman.poc.hexagonal.arch.application.port.outbound.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {
	private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
	private final InsertCustomerOutputPort insertCustomerOutputPort;

	public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort) {
		this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
		this.insertCustomerOutputPort = insertCustomerOutputPort;
	}

	@Override
	public void insert(Customer customer, String zipCode) {
		var address = findAddressByZipCodeOutputPort.find(zipCode);
		customer.setAddress(address);

		insertCustomerOutputPort.insert(customer);
	}
}
