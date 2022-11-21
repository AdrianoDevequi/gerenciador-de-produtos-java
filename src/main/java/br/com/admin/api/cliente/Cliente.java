package br.com.admin.api.cliente;

import br.com.admin.api.categoria.Categoria;
import br.com.admin.api.endereco.Endereco;
import br.com.admin.api.fornecedor.DadosFornecedor;
import br.com.admin.api.fornecedor.Fornecedor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tb_cliente")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    public Cliente(DadosCliente dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		
		this.endereco = new Endereco(dados.endereco());
	}
    
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE })
	private Endereco endereco;
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
	private String email;
	private String telefone;

    
	public void atualizarInformacoes(DadosAtualizarCliente dados) {
			this.nome = dados.nome();
			this.email = dados.email();
			this.telefone = dados.telefone();
			
			this.endereco.atualizarInformacoes(dados.endereco());

	}

}
