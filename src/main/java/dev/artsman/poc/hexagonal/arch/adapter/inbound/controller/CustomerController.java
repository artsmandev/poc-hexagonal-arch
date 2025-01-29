package dev.artsman.poc.hexagonal.arch.adapter.inbound.controller;

import dev.artsman.poc.hexagonal.arch.adapter.inbound.controller.mapper.CustomerMapper;
import dev.artsman.poc.hexagonal.arch.adapter.inbound.controller.request.CustomerRequest;
import dev.artsman.poc.hexagonal.arch.adapter.inbound.controller.response.CustomerResponse;
import dev.artsman.poc.hexagonal.arch.application.port.inbound.FindCustomerByIdInputPort;
import dev.artsman.poc.hexagonal.arch.application.port.inbound.InsertCustomerInputPort;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
	private final InsertCustomerInputPort insertCustomerInputPort;
	private final CustomerMapper customerMapper;
	private final FindCustomerByIdInputPort findCustomerByIdInputPort;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> insert(@RequestBody CustomerRequest customerRequest) {
		var customer = customerMapper.toCustomer(customerRequest);
		insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponse> findById(@PathVariable UUID id) {
		var customer = findCustomerByIdInputPort.find(id);
		var customerResponse = customerMapper.toCustomerResponse(customer);
		return ResponseEntity.ok().body(customerResponse);
	}
}
