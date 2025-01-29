package dev.artsman.poc.hexagonal.arch.application.port.outbound;

import dev.artsman.poc.hexagonal.arch.application.core.domain.Customer;
import java.util.Optional;
import java.util.UUID;

public interface FindCustomerByIdOutputPort {
	Optional<Customer> find(UUID id);
}
