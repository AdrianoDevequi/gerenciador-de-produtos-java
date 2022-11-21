package br.com.admin.api.categoria;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCategoria(
		Long id,
		@NotBlank
		String nome) {

}
