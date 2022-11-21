package br.com.admin.api.categoria;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarCategoria(
		@NotNull
		Long id, 
		String nome) {

}
