package dev.artsman.poc.hexagonal.arch.application.core.domain;

import java.util.Objects;

public final class Address {
	private String street;
	private String city;
	private String state;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Address address)) {
			return false;
		}
		return Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(state, address.state);
	}

	@Override
	public int hashCode() {
		return Objects.hash(street, city, state);
	}

	@Override
	public String toString() {
		return "Address{" + "street='" + street + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + '}';
	}
}
