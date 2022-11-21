package br.com.admin.api.produto;

import br.com.admin.api.categoria.Categoria;
import br.com.admin.api.fornecedor.Fornecedor;

public record DadosListagemProduto(
		Long id,
		String nome,
		String descricao,
		String preco,
		Categoria categoria,
		Fornecedor fornecedor) {
	
	public DadosListagemProduto(Produto produto) {
		this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getCategoria(), produto.getFornecedor());
	}
	
}
