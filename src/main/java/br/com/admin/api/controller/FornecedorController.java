package br.com.admin.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.admin.api.categoria.Categoria;
import br.com.admin.api.categoria.CategoriaRepository;
import br.com.admin.api.categoria.DadosCadastroCategoria;
import br.com.admin.api.categoria.DadosListagemCategoria;
import br.com.admin.api.fornecedor.DadosAtualizarFornecedor;
import br.com.admin.api.fornecedor.DadosCadastroFornecedor;
import br.com.admin.api.fornecedor.DadosFornecedor;
import br.com.admin.api.fornecedor.DadosListagemFornecedor;
import br.com.admin.api.fornecedor.Fornecedor;
import br.com.admin.api.fornecedor.FornecedorRepository;
import br.com.admin.api.produto.DadosAtualizacaoProduto;
import br.com.admin.api.produto.DadosCadastroProduto;
import br.com.admin.api.produto.DadosListagemProduto;
import br.com.admin.api.produto.Produto;
import br.com.admin.api.produto.ProdutoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertFalse.List;


@RestController
@RequestMapping("fornecedores")
public class FornecedorController {
	
	@Autowired
	private FornecedorRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroFornecedor dados) {
		repository.save(new Fornecedor(dados));
	}
	
	@GetMapping
	public Page<DadosListagemFornecedor> listarPagina(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemFornecedor::new);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizarFornecedor dados) {
		var fornecedor= repository.getReferenceById(dados.id());
		fornecedor.atualizarInformacoes(dados);
	}
	
	@DeleteMapping(path = "/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
