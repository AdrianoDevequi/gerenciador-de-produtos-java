package br.com.admin.api.produto;

import br.com.admin.api.categoria.Categoria;
import br.com.admin.api.fornecedor.Fornecedor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "tb_produto")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    public Produto(DadosCadastroProduto dados) {
		this.nome = dados.nome();
		this.descricao = dados.descricao();
		this.preco = dados.preco();

		this.categoria = new Categoria(dados.categoria());
		
		this.fornecedor = new Fornecedor(dados.fornecedor());
		
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String preco;
    
    
	@ManyToOne(cascade=CascadeType.MERGE)
	private Categoria categoria;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private Fornecedor fornecedor;

	public void atualizarInformacoes(@Valid DadosAtualizacaoProduto dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		if(dados.descricao() != null) {
			this.descricao = dados.descricao();
		}
		if(dados.preco() != null) {
			this.preco = dados.preco();
		}

	}

}