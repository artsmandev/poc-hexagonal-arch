package dev.artsman.poc.hexagonal.arch.adapter.outbound.http.client;

import dev.artsman.poc.hexagonal.arch.adapter.inbound.controller.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "findAddressByZipCode", url = "${apis.address.baseUri}")
public interface FindAddressByZipCodeHttpClient {
	@GetMapping("/address/{zipCode}")
	AddressResponse find(@PathVariable String zipCode);
}
