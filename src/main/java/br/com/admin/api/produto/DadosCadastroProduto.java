package br.com.admin.api.produto;

import br.com.admin.api.categoria.DadosCadastroCategoria;
import br.com.admin.api.fornecedor.DadosCadastroFornecedor;
import br.com.admin.api.fornecedor.DadosFornecedor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroProduto(
		@NotBlank
		String nome, 
		@NotBlank
		String descricao, 
		@NotBlank
		String preco,
		DadosCadastroCategoria categoria,
		DadosCadastroFornecedor fornecedor) {

}
