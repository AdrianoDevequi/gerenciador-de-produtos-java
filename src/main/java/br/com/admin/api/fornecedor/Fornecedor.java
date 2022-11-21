package br.com.admin.api.fornecedor;

import br.com.admin.api.categoria.Categoria;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tb_fornecedor")
@Entity(name = "Fornecedor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fornecedor {

    public Fornecedor(DadosCadastroFornecedor dados) {
    	if(dados.id() != null) {
    		this.id = dados.id();
    	}
		this.nome = dados.nome();
	}
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;

    
	public void atualizarInformacoes(DadosAtualizarFornecedor dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
	
	}

}
