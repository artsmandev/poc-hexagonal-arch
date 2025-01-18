package dev.artsman.poc.hexagonal.arch.application.port.outbound;

import dev.artsman.poc.hexagonal.arch.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
	void insert(Customer customer);
}
