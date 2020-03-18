package br.com.zup.velorean.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carro {

	@Id
	private String placa; 
	private String nome;
	private String cor;
	private String fabricante;
	@Column(name="vel_max")
	private float velMax;
	private float peso;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public float getVelocidadeMaxima() {
		return velMax;
	}
	public void setVelMax(float velMax) {
		this.velMax = velMax;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Carro [placa=" + placa + ", nome=" + nome + ", cor=" + cor + ", fabricante=" + fabricante + ", velMax="
				+ velMax + ", peso=" + peso + "]";
	}

	
}
