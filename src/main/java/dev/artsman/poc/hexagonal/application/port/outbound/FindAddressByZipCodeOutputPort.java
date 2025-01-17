package dev.artsman.poc.hexagonal.application.port.outbound;

import dev.artsman.poc.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
	Address find(String zipCode);
}
