package br.com.fiap.persistencia.bean;

import java.io.Serializable;

public class Veiculo implements Serializable{

	private static final long serialVersionUID = 118L;
	private int idVeiculo;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	private int anoModelo;
	private Patio patio;
	
	public int getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public int getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}
	public Patio getPatio() {
		if(patio == null){
			patio = new Patio();
		}
		return patio;
	}
	public void setPatio(Patio patio) {
		this.patio = patio;
	}
}
