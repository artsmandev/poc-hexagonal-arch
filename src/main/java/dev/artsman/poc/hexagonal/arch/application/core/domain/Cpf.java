package dev.artsman.poc.hexagonal.arch.application.core.domain;

import java.util.Objects;

public class Cpf {
	private String number;
	private boolean isValid;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean valid) {
		isValid = valid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Cpf cpf)) {
			return false;
		}
		return Objects.equals(number, cpf.number);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(number);
	}

	@Override
	public String toString() {
		return "Cpf{" + "number='" + number + '\'' + ", isValid=" + isValid + '}';
	}
}
