package br.com.admin.api.fornecedor;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroFornecedor(
		Long id,
		@NotBlank
		String nome) {
}
