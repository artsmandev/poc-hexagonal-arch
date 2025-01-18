package dev.artsman.poc.hexagonal.arch.application.port.outbound;

import dev.artsman.poc.hexagonal.arch.application.core.domain.Address;
import java.util.UUID;

public interface FindAddressByZipCodeOutputPort {
	Address find(UUID zipCode);
}
