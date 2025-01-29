package dev.artsman.poc.hexagonal.arch.application.core.usecase;

import dev.artsman.poc.hexagonal.arch.application.core.domain.Customer;
import dev.artsman.poc.hexagonal.arch.application.port.inbound.FindCustomerByIdInputPort;
import dev.artsman.poc.hexagonal.arch.application.port.outbound.FindCustomerByIdOutputPort;
import java.util.UUID;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {
	private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

	public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
		this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
	}

	@Override
	public Customer find(UUID id) {
		return findFake(id);
	}

	private Customer findFake(UUID id) {
		return findCustomerByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Customer not found"));
	}
}
