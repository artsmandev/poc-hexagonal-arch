package dev.artsman.poc.hexagonal.arch.adapter.inbound.controller.mapper;

import dev.artsman.poc.hexagonal.arch.adapter.inbound.controller.request.CustomerRequest;
import dev.artsman.poc.hexagonal.arch.adapter.inbound.controller.response.CustomerResponse;
import dev.artsman.poc.hexagonal.arch.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {
	@Mapping(source = "cpf", target = "cpf.number")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "address", ignore = true)
	@Mapping(target = "cpf.valid", ignore = true)
	Customer toCustomer(CustomerRequest customerRequest);

	CustomerResponse toCustomerResponse(Customer customer);
}
