package dev.artsman.poc.hexagonal.arch.adapter.inbound.controller.response;

import lombok.Data;

@Data
public final class CpfResponse {
	private String number;
	private boolean valid;
}
