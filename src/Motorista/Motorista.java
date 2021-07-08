package Motorista;

import Veiculo.Veiculo;

public class Motorista {

	public String nome;
	public int idade;
	public String categoriaHabilitacao;
	public Veiculo veiculo;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCategoriaHabilitacao() {
		return categoriaHabilitacao;
	}
	public void setCategoriaHabilitacao(String categoriaHabilitacao) {
		this.categoriaHabilitacao = categoriaHabilitacao;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
}