package dev.artsman.poc.hexagonal.arch.application.core.domain;

import java.util.Objects;
import java.util.UUID;

public class Customer {
	private UUID id;
	private String name;
	private Address address;
	private Cpf cpf;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Cpf getCpf() {
		return cpf;
	}

	public void setCpf(Cpf cpf) {
		this.cpf = cpf;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Customer customer)) {
			return false;
		}
		return Objects.equals(id, customer.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "Customer{" + "id=" + id + ", name='" + name + '\'' + ", address=" + address + ", cpf=" + cpf + '}';
	}
}
