package dev.artsman.poc.hexagonal.arch.adapter.outbound.repository.mapper;

import dev.artsman.poc.hexagonal.arch.adapter.outbound.repository.entity.CustomerEntity;
import dev.artsman.poc.hexagonal.arch.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerEntityMapper {

	CustomerEntity toCustomerEntity(Customer customer);

	Customer toCustomer(CustomerEntity customerEntity);
}
