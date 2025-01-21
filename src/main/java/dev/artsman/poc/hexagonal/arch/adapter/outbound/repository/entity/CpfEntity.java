package dev.artsman.poc.hexagonal.arch.adapter.outbound.repository.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cpf")
public class CpfEntity {
	private String value;
	private boolean isValid;
}
