package dev.artsman.poc.hexagonal.arch.config;

import dev.artsman.poc.hexagonal.arch.application.core.usecase.InsertCustomerUseCase;
import dev.artsman.poc.hexagonal.arch.application.port.outbound.FindAddressByZipCodeOutputPort;
import dev.artsman.poc.hexagonal.arch.application.port.outbound.InsertCustomerOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class InsertCustomerConfig {
	@Bean
	InsertCustomerUseCase insertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort) {
		return new InsertCustomerUseCase(findAddressByZipCodeOutputPort, insertCustomerOutputPort);
	}
}
