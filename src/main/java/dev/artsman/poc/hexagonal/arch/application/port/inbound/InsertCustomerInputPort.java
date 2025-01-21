package dev.artsman.poc.hexagonal.arch.application.port.inbound;

import dev.artsman.poc.hexagonal.arch.application.core.domain.Customer;

public interface InsertCustomerInputPort {
	void insert(Customer customer, String zipCode);
}
