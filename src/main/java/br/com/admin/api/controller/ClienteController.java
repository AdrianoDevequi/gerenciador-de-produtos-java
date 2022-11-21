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

import br.com.admin.api.cliente.Cliente;
import br.com.admin.api.cliente.ClienteRepository;
import br.com.admin.api.cliente.DadosAtualizarCliente;
import br.com.admin.api.cliente.DadosCliente;
import br.com.admin.api.cliente.DadosListagemCliente;
import br.com.admin.api.endereco.DadosAtualizarEndereco;
import br.com.admin.api.fornecedor.DadosAtualizarFornecedor;
import br.com.admin.api.fornecedor.DadosFornecedor;
import br.com.admin.api.fornecedor.DadosListagemFornecedor;
import br.com.admin.api.fornecedor.Fornecedor;
import br.com.admin.api.fornecedor.FornecedorRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCliente dados) {
		repository.save(new Cliente(dados));
	}
	
	@GetMapping
	public Page<DadosListagemCliente> listarPagina(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemCliente::new);
	}
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizarCliente dados) {
		var cliente= repository.getReferenceById(dados.id());
		cliente.atualizarInformacoes(dados);
	}
	
	@DeleteMapping(path = "/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
