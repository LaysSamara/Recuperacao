package Veiculo;

import java.util.List;
import java.util.Scanner;

public class veiculoController {

	private Scanner tec;

	public veiculoController() {
		this.tec = new Scanner(System.in);
	}

	public int leOpcao(){
		System.out.print("> ");
		return tec.nextInt();
	}

	public Veiculo cadastrarVeiculo() {

		Veiculo veiculo = new Veiculo();

		System.out.print("Informe o modelo do veiculo: ");
		veiculo.setModelo(tec.next());
		
		System.out.print("Informe o ano do veiculo: ");
		veiculo.setAno(tec.nextInt());
		
		System.out.print("Informe o tipo de combustivel do veiculo: ");
		veiculo.setTipoCombustivel(tec.next());
		
		System.out.print("Informe a placa do veiculo: ");
		veiculo.setPlaca(tec.nextInt());
		
		System.out.println("Informe a marca do veiculo:");

		return veiculo;
	}

	public List<Veiculo> listarVeiculo(List<Veiculo> veiculos) {

		if(veiculos.isEmpty()) {
			System.out.println("Năo possui cursos cadastrados.");
			return null;
		}

		System.out.printf("| %2f | %20s | %4f | %10s | %8f | \n", 
				"ID","Modelo","Ano","Combustível","Placa");

		for(int i = 0; i < veiculos.size(); i++) {
			System.out.printf("| %2f | %20s | %4f | %10s | %8f |\n",
					veiculos.get(i).getModelo(),
					veiculos.get(i).getAno(),
					veiculos.get(i).getTipoCombustivel(),
					veiculos.get(i).getPlaca());
		}		
		return veiculos;
	}

	public List<Veiculo> editarVeiculo(List<Veiculo> veiculos) {

		listarVeiculo(veiculos);

		Veiculo veiculo = new Veiculo();

		if(veiculos.isEmpty()) {
			return null;
		}

		System.out.print("Informe o Id do veiculo para editar: ");
		System.out.println("                                   ");
		int idVeiculo = tec.nextInt() - 1;

		System.out.println("--- Editar nome ---");
		System.out.println("--- Editar ano ---");
		System.out.println("--- Editar combustivel ---");
		System.out.println("--- Editar placa ---");
		int opcao = tec.nextInt();

		switch (opcao) {
		case 1:
			System.out.println("--- Editar modelo ---");
			tec.next();
			
			System.out.print("Informe o novo modelo do veiculo: ");
			veiculo.setModelo(tec.next());

			veiculos.set( idVeiculo,veiculo);
			break;
	
		case 2:
			System.out.println("--- Editar ano ---");
			tec.nextInt();

			System.out.print("Informe o novo ano do veiculo: ");
			veiculo.setAno(tec.nextInt());
	
			veiculos.set(idVeiculo,veiculo);
			break;
		
			
		case 3:
			System.out.println("--- Editar combustivel ---");
			tec.next();

			System.out.print("Informe o novo ano do veiculo: ");
			veiculo.setTipoCombustivel(tec.next());

			veiculos.set(idVeiculo,veiculo);
			break;
	
	
		case 4:
			System.out.println("--- Editar placa ---");
			tec.nextInt();
			
			System.out.print("Informe a nova placa do veiculo: ");
			veiculo.setPlaca(tec.nextInt());
	
			veiculos.set(idVeiculo,veiculo);
			break;
	
		default:
			System.out.println("Opçăo inválida!");
			break;
			}
			return veiculos;
	}

		public void excluirVeiculo(List<Veiculo> veiculo ) {

			listarVeiculo(veiculo);
			if(veiculo.isEmpty()) {
				return;
			}

			System.out.println("--- EXCLUIR CURSO ---");

			System.out.print("Informe o ID do veiculo para excluir: ");
			int idVeiculo = tec.nextInt() - 1;

			if(veiculo.size() <= idVeiculo) {
				System.out.println("Curso năo cadastrado.");

			if(!veiculo.isEmpty())
				System.out.println("Não é possível apagar o veiculo, pois ainda há estudantes.");
				return;
			}

			veiculo.remove(idVeiculo);
	}

	public void menu(List<Veiculo> veiculos) {	
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
			veiculos.add(cadastrarVeiculo());
			break;

		case 2:
			listarVeiculo(veiculos);		
			break;

		case 3:
			editarVeiculo(veiculos);
			break;

		case 4:
			excluirVeiculo(veiculos);
			break;

		case 5:
			sair = true;
			break;

		default:
			System.out.println("Opção inválida !");
			break;

		}
	}while (!sair);
	}	
}
