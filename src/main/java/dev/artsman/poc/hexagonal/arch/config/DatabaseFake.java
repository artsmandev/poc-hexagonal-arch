package dev.artsman.poc.hexagonal.arch.config;

import dev.artsman.poc.hexagonal.arch.adapter.outbound.repository.entity.CustomerEntity;
import java.util.HashMap;
import java.util.UUID;

public class DatabaseFake {
	private final static HashMap<UUID, CustomerEntity> data = new HashMap<>();

	public static void save(CustomerEntity customer) {
		var uuid = UUID.randomUUID();
		customer.setId(uuid);
		data.put(uuid, customer);
	}

	public static CustomerEntity find(UUID id) {
		return data.get(id);
	}
}
