package dev.artsman.poc.hexagonal.arch.adapter.inbound.controller.response;

import lombok.Data;

@Data
public final class AddressResponse {
	private String street;
	private String city;
	private String state;
}
