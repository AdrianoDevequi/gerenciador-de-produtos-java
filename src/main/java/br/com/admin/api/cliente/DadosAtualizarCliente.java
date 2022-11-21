package br.com.admin.api.cliente;

import br.com.admin.api.endereco.DadosAtualizarEndereco;
import br.com.admin.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosAtualizarCliente(Long id,
		@NotBlank
		String nome,
		@Email
		String email,
		@NotBlank
		String telefone,
		@Valid
		DadosAtualizarEndereco endereco) {

}
