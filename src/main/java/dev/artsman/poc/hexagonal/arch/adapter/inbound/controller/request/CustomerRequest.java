package dev.artsman.poc.hexagonal.arch.adapter.inbound.controller.request;

import lombok.Data;

@Data
public class CustomerRequest {
	private String name;
	private String cpf;
	private String zipCode;
}
