package dev.artsman.poc.hexagonal.arch.adapter.inbound.controller;

import dev.artsman.poc.hexagonal.arch.adapter.outbound.http.client.FindAddressByZipCodeHttpClient;
import dev.artsman.poc.hexagonal.arch.adapter.outbound.http.client.response.AddressResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
	private final FindAddressByZipCodeHttpClient findAddressByZipCodeHttpClient;

	@GetMapping("/{zipCode}")
	public ResponseEntity<AddressResponse> findAddressByZipCode(@PathVariable UUID zipCode) {
		var addressResponse = findAddressByZipCodeHttpClient.find(zipCode);
		return ResponseEntity.ok(addressResponse);
	}
}
