package dev.artsman.poc.hexagonal.application.port.outbound;

import dev.artsman.poc.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
	void insert(Customer customer);
}
