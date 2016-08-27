package br.com.fiap.persistencia.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "patio")
public class Patio implements Serializable{
	
	private static final long serialVersionUID = 12L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idpatio")
	private int idPatio;
	
	private String nome;
	
	@OneToMany(mappedBy="patio", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	public int getIdPatio() {
		return idPatio;
	}
	public void setIdPatio(int idPatio) {
		this.idPatio = idPatio;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
}
