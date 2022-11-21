package br.com.admin.api.endereco;

import br.com.admin.api.cliente.Cliente;
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


@Table(name = "tb_endereco")
@Entity(name = "Endereco")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {

    public Endereco(DadosEndereco dados) {
		this.logradouro = dados.logradouro();
		this.bairro = dados.bairro();
		this.cep = dados.cep();
		this.uf = dados.uf();
		this.numero = dados.numero();
		this.complemento = dados.complemento();
		this.cidade = dados.cidade();
	}
    
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
    
	public void atualizarInformacoes(DadosAtualizarEndereco dados) {
		if(dados.logradouro() != null) {
			this.logradouro = dados.logradouro();
		}
		if(dados.bairro() != null) {
			this.bairro = dados.bairro();
		}
		if(dados.cep() != null) {
			this.cep = dados.cep();
		}
		if(dados.uf() != null) {
			this.uf = dados.uf();
		}
		if(dados.numero() != null) {
			this.numero = dados.numero();
		}
		if(dados.complemento() != null) {
			this.complemento = dados.complemento();
		}
		if(dados.cidade() != null) {
			this.cidade = dados.cidade();
		}
		
	}

}
