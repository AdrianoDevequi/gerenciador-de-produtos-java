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

import br.com.admin.api.produto.DadosAtualizacaoProduto;
import br.com.admin.api.produto.DadosCadastroProduto;
import br.com.admin.api.produto.DadosListagemProduto;
import br.com.admin.api.produto.Produto;
import br.com.admin.api.produto.ProdutoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertFalse.List;


@RestController
@RequestMapping("produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroProduto dados) {
		repository.save(new Produto(dados));
	}
	
//	@GetMapping
//	public java.util.List<DadosListagemMedico> listar(){
//		return repository.findAll().stream().map(DadosListagemMedico::new).toList();
//	}
	
	@GetMapping
	public Page<DadosListagemProduto> listarPagina(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemProduto::new);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoProduto dados) {
		var medico= repository.getReferenceById(dados.id());
		medico.atualizarInformacoes(dados);
		
	}
	
	@DeleteMapping(path = "/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
