package br.com.admin.api.cliente;

import br.com.admin.api.endereco.Endereco;
import br.com.admin.api.fornecedor.Fornecedor;

public record DadosListagemCliente(		
		Long id,
		String nome,
		String email,
		String telefone,
		Endereco endereco) {
	
	public DadosListagemCliente(Cliente cliente) {
		this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco());
	}
}