package dev.artsman.poc.hexagonal.arch.adapter.outbound;

import dev.artsman.poc.hexagonal.arch.adapter.outbound.repository.CustomerRepository;
import dev.artsman.poc.hexagonal.arch.adapter.outbound.repository.mapper.CustomerEntityMapper;
import dev.artsman.poc.hexagonal.arch.application.core.domain.Customer;
import dev.artsman.poc.hexagonal.arch.application.port.outbound.InsertCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertCustomerAdapter implements InsertCustomerOutputPort {
	private final CustomerRepository customerRepository;
	private final CustomerEntityMapper customerEntityMapper;

	@Override
	public void insert(Customer customer) {
		var customerEntity = customerEntityMapper.toCustomerEntity(customer);
		customerRepository.save(customerEntity);
	}
}
