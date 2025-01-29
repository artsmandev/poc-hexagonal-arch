package dev.artsman.poc.hexagonal.arch.application.core.usecase;

import dev.artsman.poc.hexagonal.arch.application.core.domain.Customer;
import dev.artsman.poc.hexagonal.arch.application.port.inbound.FindCustomerByIdInputPort;
import dev.artsman.poc.hexagonal.arch.application.port.outbound.FindAddressByZipCodeOutputPort;
import dev.artsman.poc.hexagonal.arch.application.port.outbound.UpdateCustomerAddressOutputPort;

public class UpdateCustomerAddressUseCase {
	private final FindCustomerByIdInputPort findCustomerByIdInputPort;
	private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
	private final UpdateCustomerAddressOutputPort updateCustomerAddressOutputPort;

	public UpdateCustomerAddressUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, UpdateCustomerAddressOutputPort updateCustomerAddressOutputPort) {
		this.findCustomerByIdInputPort = findCustomerByIdInputPort;
		this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
		this.updateCustomerAddressOutputPort = updateCustomerAddressOutputPort;
	}

	public void update(Customer customer, String zipCode) {
		var customerFound = findCustomerByIdInputPort.find(customer.getId());

		var addressFound = findAddressByZipCodeOutputPort.find(zipCode);
		customerFound.setAddress(addressFound);

		updateCustomerAddressOutputPort.update(customerFound);
	}
}
