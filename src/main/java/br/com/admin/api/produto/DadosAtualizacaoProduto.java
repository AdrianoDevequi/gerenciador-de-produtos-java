package br.com.admin.api.produto;

import br.com.admin.api.categoria.DadosCadastroCategoria;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProduto(
		@NotNull
		Long id, 
		String nome, 
		String descricao, 
		String preco,
		DadosCadastroCategoria categoria ) {

}
