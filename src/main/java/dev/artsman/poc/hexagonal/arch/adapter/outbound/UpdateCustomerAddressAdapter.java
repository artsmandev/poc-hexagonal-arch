package dev.artsman.poc.hexagonal.arch.adapter.outbound;

import dev.artsman.poc.hexagonal.arch.adapter.outbound.repository.CustomerRepository;
import dev.artsman.poc.hexagonal.arch.adapter.outbound.repository.entity.CustomerEntity;
import dev.artsman.poc.hexagonal.arch.adapter.outbound.repository.mapper.CustomerEntityMapper;
import dev.artsman.poc.hexagonal.arch.application.core.domain.Customer;
import dev.artsman.poc.hexagonal.arch.application.port.outbound.UpdateCustomerAddressOutputPort;
import dev.artsman.poc.hexagonal.arch.config.DatabaseFake;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCustomerAddressAdapter implements UpdateCustomerAddressOutputPort {
	private final CustomerRepository customerRepository;
	private final CustomerEntityMapper customerEntityMapper;

	/* TO-DO
	 * replace this method with a call to the real repository
	 * customerRepository.save(customerEntity);
	 */
	@Override
	public void update(Customer customer) {
		var customerEntity = customerEntityMapper.toCustomerEntity(customer);
		updateFake(customerEntity);
	}

	private void updateFake(CustomerEntity customerEntity) {
		DatabaseFake.save(customerEntity);
	}
}
