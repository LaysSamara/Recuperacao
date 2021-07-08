package menu;

import java.util.ArrayList;
import java.util.List;

import Motorista.Motorista;
import Motorista.motoristaController;
import Veiculo.Veiculo;
import Veiculo.veiculoController;
	
	public class ProgramaPrincipal {

		public static void main(String[] args) {
			List<Motorista> motoristas = new ArrayList<>();
			List<Veiculo> veiculos = new ArrayList<>();

			veiculoController veiculoController = new veiculoController();
			motoristaController motoristaController = new motoristaController();

			boolean sair = false;

			do {
				System.out.println("------MENU------");
				System.out.println("--- 1 - MOTORISTAS ---");
				System.out.println("--- 2 - VEICULOS ---");
				System.out.println("--- 3 - SAIR ---");

				int opcao = motoristaController.leOpcao();

				switch (opcao) {
				case 1:
					motoristaController.menu(motoristas);
					break;

				case 2:
					veiculoController.menu(veiculos);
					break;

				case 3:
					sair = true;
					break;

				default:
					System.out.println("Opção inválida !");
					break;
				}
			} while (!sair);
		}
	}