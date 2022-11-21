package br.com.admin.api.categoria;

import br.com.admin.api.produto.Produto;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "tb_categoria")
@Entity(name = "Categoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria {

    public Categoria(DadosCadastroCategoria dados) {
    	if(dados.id() != null) {
    		this.id = dados.id();
    	}
		this.nome = dados.nome();
	}
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;

    
	public void atualizarInformacoes(DadosAtualizarCategoria dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
	
	}

}
