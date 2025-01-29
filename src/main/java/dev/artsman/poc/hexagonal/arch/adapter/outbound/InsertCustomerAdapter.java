package dev.artsman.poc.hexagonal.arch.adapter.outbound;

import dev.artsman.poc.hexagonal.arch.adapter.outbound.repository.CustomerRepository;
import dev.artsman.poc.hexagonal.arch.adapter.outbound.repository.entity.CustomerEntity;
import dev.artsman.poc.hexagonal.arch.adapter.outbound.repository.mapper.CustomerEntityMapper;
import dev.artsman.poc.hexagonal.arch.application.core.domain.Customer;
import dev.artsman.poc.hexagonal.arch.application.port.outbound.InsertCustomerOutputPort;
import dev.artsman.poc.hexagonal.arch.config.DatabaseFake;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertCustomerAdapter implements InsertCustomerOutputPort {
	private final CustomerRepository customerRepository;
	private final CustomerEntityMapper customerEntityMapper;

	/* TO-DO
	 * replace this method with a call to the real repository
	 * customerRepository.save(customerEntity);
	 */
	@Override
	public void insert(Customer customer) {
		var customerEntity = customerEntityMapper.toCustomerEntity(customer);
		insertFake(customerEntity);
	}

	private void insertFake(CustomerEntity customerEntity) {
		DatabaseFake.save(customerEntity);
	}
}
