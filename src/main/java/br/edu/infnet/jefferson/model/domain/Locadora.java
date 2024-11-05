package br.edu.infnet.jefferson.model.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "TLocadora")
public class Locadora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private String cnpj;
	private String razaosocial;
	
	@Transient
	private List<Veiculo> veiculos;
	
	@Transient
	private Endereco endereco;
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaosocial() {
		return razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

		
	public Locadora() {
		veiculos = new ArrayList<Veiculo>();
		
	}
	
	@Override
	public String toString() {

		return String.format("[%s] Locadora %s Cadastrada com sucesso! %s; Veiculos: %d", 
				cnpj,
				razaosocial,
				endereco,
				veiculos.size()
				);
		
	}
	
	
}
