package dev.artsman.poc.hexagonal.arch.application.port.outbound;

import dev.artsman.poc.hexagonal.arch.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
	Address find(String zipCode);
}
