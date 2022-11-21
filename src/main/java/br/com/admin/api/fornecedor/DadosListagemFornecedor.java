package br.com.admin.api.fornecedor;

import br.com.admin.api.categoria.Categoria;

public record DadosListagemFornecedor(
		Long id,
		String nome) {
	
	public DadosListagemFornecedor(Fornecedor fornecedor) {
		this(fornecedor.getId(), fornecedor.getNome());
	}
}
