package dev.artsman.poc.hexagonal.arch.adapter.outbound;

import dev.artsman.poc.hexagonal.arch.adapter.outbound.repository.CustomerRepository;
import dev.artsman.poc.hexagonal.arch.adapter.outbound.repository.mapper.CustomerEntityMapper;
import dev.artsman.poc.hexagonal.arch.application.core.domain.Customer;
import dev.artsman.poc.hexagonal.arch.application.port.outbound.FindCustomerByIdOutputPort;
import dev.artsman.poc.hexagonal.arch.config.DatabaseFake;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {
	private final CustomerRepository customerRepository;
	private final CustomerEntityMapper customerEntityMapper;

	@Override
	public Optional<Customer> find(UUID id) {
		return findFake(id);
	}

	/* TO-DO
	 * replace this method with a call to the real repository
	 * customerRepository.save(customerEntity);
	 */
	 private Optional<Customer> findFake(UUID id) {
		var customerEntity = DatabaseFake.find(id);
		return Optional.ofNullable(customerEntity).map(customerEntityMapper::toCustomer);
	}
}
