package br.com.fiap.persistencia.bean;

import java.io.Serializable;
import java.util.List;

public class Patio implements Serializable{
	
	private static final long serialVersionUID = 12L;
	
	private int idPatio;
	private String nome;
	private List<Veiculo> veiculos;
	
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
