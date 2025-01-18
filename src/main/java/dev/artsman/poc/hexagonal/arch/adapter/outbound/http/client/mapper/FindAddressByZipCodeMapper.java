package dev.artsman.poc.hexagonal.arch.adapter.outbound.http.client.mapper;

import dev.artsman.poc.hexagonal.arch.adapter.outbound.http.client.response.AddressResponse;
import dev.artsman.poc.hexagonal.arch.application.core.domain.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FindAddressByZipCodeMapper {
		Address toAddress(AddressResponse addressResponse);
}
