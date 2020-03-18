package br.com.zup.velorean.programa;

import java.util.Scanner;
import br.com.zup.velorean.dao.CarrosDAO;
import br.com.zup.velorean.pojo.Carro;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		CarrosDAO carroDAO = new CarrosDAO();
		System.out.println("Seja bem vindo ao cadastro de carro!\n");
		
		Scanner input = new Scanner(System.in);
		
		int opcao = 0;
		do {
			System.out.printf("| %-6s %-10s |\n","1 - ","inserir");
			System.out.printf("| %-6s %-10s |\n","2 - ","remover");
			System.out.printf("| %-6s %-10s |\n","3 - ","exibir todos");
			System.out.printf("| %-6s %-10s |\n","4 - ","atualizar");
			System.out.printf("| %-6s %-10s |\n","5 - ","exibir um");
			opcao = input.nextInt();
			
			switch (opcao) {
			case 1:
				AdicionaCarro(carroDAO, input);				
				break;
			case 2:
				removeCarro(carroDAO, input);
				break;
			case 3:
				exibeListaCarros(carroDAO);
				break;
			case 4:
				alteraNome(carroDAO, input);
				break;
			case 5:
				exibeCarro(carroDAO, input);
			}
		} while (opcao != 0);
		input.close();
	}

	private static void exibeListaCarros(CarrosDAO carroDAO) {
		System.out.printf("%-10s %-8s %-8s %-10s %-20s %-5s\n", "nome", "placa", "cor", "fabricação","velocidade maxima", "peso");
			for ( Carro carro : carroDAO.listaCarro().values()) {
				System.out.printf("%-10s %-8s %-8s %-10s %-16fkm/h %-5fkg\n",carro.getNome(), carro.getPlaca(),carro.getCor(),
						carro.getFabricante(), carro.getVelocidadeMaxima(), carro.getPeso());
			}
	}

	private static void removeCarro(CarrosDAO carroDAO, Scanner input) {
		System.out.println("digite a placa do carro que deseja remover:");
		String placa = input.next();
		carroDAO.removeCarro(placa);
	}

	private static void AdicionaCarro(CarrosDAO carroDAO, Scanner input) {
		System.out.println("Digite a nome do carro:");
		String nome = input.next();
		System.out.println("Digite a placa do carro:");
		String placa = input.next();
		System.out.println("Digite a cor do carro:");
		String cor = input.next();
		System.out.println("Digite o fabricante do carro:");
		String fabricante = input.next();
		System.out.println("Digite velocidade maxima do carro");
		float velocidadeMaxima = input.nextFloat();
		System.out.println("Digite o peso do carro:");
		float peso = input.nextFloat();
		carroDAO.insereCarro(nome, placa, cor, fabricante, velocidadeMaxima, peso);
	}
	
	private static void alteraNome(CarrosDAO carroDAO, Scanner input) {
		System.out.println("Digite a placa do carro que deseja alterar:");
		String placa = input.next();
		System.out.println("Digite o nome que deseja alterar");
		String nome = input.next();
		carroDAO.alteraCarro(placa, nome);
	}

	private static void exibeCarro(CarrosDAO carrosDAO, Scanner input) {
		System.out.println("Digite a placa do carro que deseja exibir:");
		String placa = input.next();
		System.out.println(carrosDAO.exibeCarro(placa));
	}
}
