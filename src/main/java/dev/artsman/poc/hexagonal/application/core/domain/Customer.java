package dev.artsman.poc.hexagonal.application.core.domain;

import java.util.UUID;

public record Customer(UUID id, String name, Address address, String cpf, boolean isValid) {}
