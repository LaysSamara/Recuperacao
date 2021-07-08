package Veiculo;

import Marca.Marca;

public class Veiculo extends Marca {

	public String modelo;
	public int ano;
	public String tipoCombustivel ;
	public float placa;
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getTipoCombustivel() {
		return tipoCombustivel;
	}
	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
	public float getPlaca() {
		return placa;
	}
	public void setPlaca(float placa) {
		this.placa = placa;
	}
}
