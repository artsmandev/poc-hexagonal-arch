package dev.artsman.poc.hexagonal.arch.adapter.outbound.repository.entity;

import dev.artsman.poc.hexagonal.arch.application.core.domain.Cpf;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customer")
public class CustomerEntity {
	@Id
	private UUID id;
	private String name;
	private AddressEntity address;
	private Cpf cpf;
}
