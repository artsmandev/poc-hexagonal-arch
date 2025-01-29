package dev.artsman.poc.hexagonal.arch.application.port.inbound;

import dev.artsman.poc.hexagonal.arch.application.core.domain.Customer;
import java.util.UUID;

public interface FindCustomerByIdInputPort {
	Customer find(UUID id);
}
