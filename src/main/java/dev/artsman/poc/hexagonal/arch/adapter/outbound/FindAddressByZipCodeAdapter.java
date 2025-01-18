package dev.artsman.poc.hexagonal.arch.adapter.outbound;

import dev.artsman.poc.hexagonal.arch.adapter.outbound.http.client.FindAddressByZipCodeHttpClient;
import dev.artsman.poc.hexagonal.arch.adapter.outbound.http.client.mapper.FindAddressByZipCodeMapper;
import dev.artsman.poc.hexagonal.arch.application.core.domain.Address;
import dev.artsman.poc.hexagonal.arch.application.port.outbound.FindAddressByZipCodeOutputPort;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {
	private final FindAddressByZipCodeHttpClient findAddressByZipCodeHttpClient;
	private final FindAddressByZipCodeMapper findAddressByZipCodeMapper;

	@Override
	public Address find(UUID zipCode) {
		var addressResponse = findAddressByZipCodeHttpClient.find(zipCode);
		return findAddressByZipCodeMapper.toAddress(addressResponse);
	}
}

