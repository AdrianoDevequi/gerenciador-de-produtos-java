package br.com.admin.api.fornecedor;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarFornecedor(
		@NotNull
		Long id,
		@NotNull
		String nome) {

}
