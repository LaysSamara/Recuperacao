package Motorista;

import java.util.List;
import java.util.Scanner;

import Veiculo.Veiculo;

public class motoristaController {
	private Scanner tec;

	public motoristaController(){
		tec = new Scanner(System.in);
	}

	public int leOpcao(){
		System.out.print("> ");
		return tec.nextInt();
	}
	public Motorista cadastrarMotorista(List<Veiculo> veiculos){
		Motorista motorista = new Motorista();
		Veiculo veiculo = new Veiculo();
		
		System.out.println("--- CADASTRAR MOTORISTA ---");
		System.out.print("Informe o nome: ");
		tec.nextLine();
		motorista.setNome(tec.nextLine());

		System.out.print("Informe a idade: ");
		motorista.setIdade(tec.nextInt());
		
		System.out.print("Informe categoria de abilitação: ");
		motorista.setCategoriaHabilitacao(tec.next());

		System.out.print("Informe o veiculo: ");
		motorista.setVeiculo(veiculo);
		
		return motorista;
	}

	public List<Motorista> listarMotorista(List<Motorista> motoristas) {

		if(motoristas.isEmpty()) {
			System.out.println("Năo possui motorista cadastrado");
			return null;
		}

		System.out.printf("| %10s | %3fs | %15s | %20s |\n", 
				"Motorista","Idade","Categoria","Veiculo");

		for(int i = 0; i < motoristas.size(); i++) {
			System.out.printf("| %10s | %3f | %15s | %20s |\n",
					motoristas.get(i).getNome(),
					motoristas.get(i).getIdade(),
					motoristas.get(i).getCategoriaHabilitacao(),
					motoristas.get(i).getVeiculo());
		}		
		return motoristas;
	}

	public List<Motorista> editarMotorista(List<Motorista> motoristas) {
		Motorista motorista = new Motorista();
		listarMotorista(motoristas);

		if(motoristas.isEmpty()) {
			return null;
		}
		
		System.out.println("--- EDITAR MOTORISTA ---");
		System.out.print("Informe o Id do motorista para editar: ");
		System.out.println("                                   ");
		int idMotorista = tec.nextInt() - 1;

		System.out.println("--- 1) Editar nome ---");
		System.out.println("--- 2) Editar idade ---");
		System.out.println("--- 3) Editar categoria ---");
		System.out.println("--- 4) Editar veiculo ---");
		int opcao = tec.nextInt();

		switch (opcao) {
		case 1:
			System.out.print("Informe o novo nome do motorista: ");
			motorista.setNome(tec.next());

			motorista.setIdade(motoristas.get(idMotorista).getIdade());
			motorista.setCategoriaHabilitacao(motoristas.get(idMotorista).getCategoriaHabilitacao());
			motorista.setVeiculo(motoristas.get(idMotorista).getVeiculo());
			motoristas.set(idMotorista, motorista);
			break;

		case 2:
			System.out.print("Informe a nova idade do motorista: ");
			motorista.setIdade(tec.nextInt());

			motorista.setNome(motoristas.get(idMotorista).getNome());
			motorista.setCategoriaHabilitacao(motoristas.get(idMotorista).getCategoriaHabilitacao());
			motorista.setVeiculo(motoristas.get(idMotorista).getVeiculo());
			motoristas.set(idMotorista, motorista);
			break;
			
		case 3:
			System.out.print("Informe a nova categoria do motorista: ");
			motorista.setCategoriaHabilitacao(tec.next());

			motorista.setNome(motoristas.get(idMotorista).getNome());
			motorista.setVeiculo(motoristas.get(idMotorista).getVeiculo());
			motoristas.set(idMotorista, motorista);
			break;

		case 4:
			System.out.print("Informe o novo veiculo do motorista: ");
			motorista.setVeiculo(tec.next());

			motorista.setNome(motoristas.get(idMotorista).getNome());
			motorista.setIdade(motoristas.get(idMotorista).getIdade());
			motorista.setCategoriaHabilitacao(motoristas.get(idMotorista).getCategoriaHabilitacao());
			motoristas.set(idMotorista,motorista);
			break;

		default:
			System.out.println("Opçăo inválida!");
			break;
		}
		return motoristas;


	}

	public void excluirMotorista(List<Motorista> motoristas) {

		listarMotorista(motoristas);

		if(motoristas.isEmpty()) {
			return;
		}

		System.out.println("--- EXCLUIR MOTORISTA ---");

		System.out.print("Informe o ID do motorista para excluir: ");
		int idMotorista = tec.nextInt() - 1;

		if(motoristas.size() <= idMotorista) {
			System.out.println("Aluno năo cadastrado.");
		if(!motoristas.isEmpty())
			System.out.println("Não é possível apagar o motorista, pois ainda tem cadastro.");
			return;
		}

		motoristas.remove(idMotorista);
	}

	public void menu(List<Motorista> motoristas) {
		boolean sair = false;
		do {
		System.out.println("--- 1 - Cadastrar ---");
		System.out.println("--- 2 - Listar ---");
		System.out.println("--- 3 - Editar ---");
		System.out.println("--- 4 - Excluir ---");
		System.out.println("--- 5 - Voltar ao menu ---");

		int opcao = leOpcao();
		switch(opcao) {

		case 1:
			motoristas.add(cadastrarMotorista());
			break;

		case 2:
			listarMotorista(motoristas);
			break;

		case 3:
			editarMotorista(motoristas);
			break;

		case 4:
			excluirMotorista(motoristas);
			break;

		case 5:
			sair = true;
			break;

		default:
			System.out.println("Opção inválida !");
			break;

		}
	}while(!sair);

	}

}

