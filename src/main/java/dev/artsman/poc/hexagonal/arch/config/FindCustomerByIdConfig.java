package dev.artsman.poc.hexagonal.arch.config;

import dev.artsman.poc.hexagonal.arch.application.core.usecase.FindCustomerByIdUseCase;
import dev.artsman.poc.hexagonal.arch.application.port.outbound.FindCustomerByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {
	@Bean
	public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
		return new FindCustomerByIdUseCase(findCustomerByIdOutputPort);
	}
}
