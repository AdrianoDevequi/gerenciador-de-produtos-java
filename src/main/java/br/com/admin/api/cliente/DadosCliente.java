package br.com.admin.api.cliente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import br.com.admin.api.endereco.DadosEndereco;

public record DadosCliente(
		Long id,
		@NotBlank
		String nome,
		@Email
		String email,
		@NotBlank
		String telefone,
		@Valid
		DadosEndereco endereco) {

}
