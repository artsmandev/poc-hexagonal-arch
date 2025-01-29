package dev.artsman.poc.hexagonal.arch.adapter.inbound.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {
	private String name;
	private CpfResponse cpf;
	private AddressResponse address;
}
