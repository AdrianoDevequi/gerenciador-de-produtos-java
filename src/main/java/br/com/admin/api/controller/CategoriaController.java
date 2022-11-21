package br.com.admin.api.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.admin.api.categoria.Categoria;
import br.com.admin.api.categoria.CategoriaRepository;
import br.com.admin.api.categoria.DadosAtualizarCategoria;
import br.com.admin.api.categoria.DadosCadastroCategoria;

import br.com.admin.api.categoria.DadosListagemCategoria;
import br.com.admin.api.fornecedor.DadosAtualizarFornecedor;
import br.com.admin.api.produto.DadosAtualizacaoProduto;
import br.com.admin.api.produto.DadosCadastroProduto;
import br.com.admin.api.produto.DadosListagemProduto;
import br.com.admin.api.produto.Produto;
import br.com.admin.api.produto.ProdutoRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertFalse.List;


@RestController
@RequestMapping("categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@PostMapping
	@Transactional
	@ResponseStatus(value = HttpStatus.ACCEPTED, reason="Cadastrado com sucesso!")
	public void cadastrar(@RequestBody @Valid DadosCadastroCategoria dados) {
		repository.save(new Categoria(dados));
		System.out.println("Cadastrado com sucesso!");

	}
	
	@GetMapping
	public Page<DadosListagemCategoria> listarPagina(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemCategoria::new);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizarCategoria dados) {
		var fornecedor= repository.getReferenceById(dados.id());
		fornecedor.atualizarInformacoes(dados);
	}
	
	@DeleteMapping(path = "/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}

	
}
