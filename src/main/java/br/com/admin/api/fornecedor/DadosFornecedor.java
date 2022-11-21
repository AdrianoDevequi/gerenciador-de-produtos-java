package br.com.admin.api.fornecedor;

import jakarta.validation.constraints.NotBlank;

public record DadosFornecedor(
		Long id,
		@NotBlank
		String nome ) {
}