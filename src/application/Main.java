package application;

import java.util.Scanner;

import model.Carro;
import model.Fila;
import model.ListaEncadeada;
import model.Menu;

public class Main {

	public static void main(String[] args) {
		Fila<Carro> fila = Carro.carrosCadastrados();
		ListaEncadeada<Carro> carrosLavados = new ListaEncadeada<Carro>();
		int opcao;
		@SuppressWarnings("resource")
		Scanner leitor = new Scanner(System.in);

		do {
			Menu.menu();
			System.out.print("|> Selecione uma opção: ");
			opcao = leitor.nextInt();
			System.out.println("");

			switch (opcao) {
			case 1:
				// Adiciona novo carro na fila
				fila.enfilheira(Carro.cadastrarCarro());
				break;

			case 2:
				// Verifica se tem carros na fila
				if (fila.estaVazia()) {
					System.out.println("Não tem carros na fila!\n");
				} else {
					// Ver carros que estão na fila
					System.out.println("PRÓXIMOS CARROS A SEREM ATENDIDOS:\n");
					fila.imprimeFila(fila);
					System.out.println("");
					System.out.println(fila.getTamanho() + " Carros na fila!\n");
				}
				break;

			case 3:
				// Verifica se tem carros aguardando para serem lavados
				if (fila.estaVazia()) {
					System.out.println("Não tem carros para lavar!\n");
					break;
				}
				// Faz a limpeza de 3 carros na fila
				System.out.println("INICIANDO LIMPEZA!");
				final int MAX = 3;
				int cont = 0;
				while (cont < MAX) {
					if (fila.estaVazia()) {
						break;
					}
					Carro carro = fila.get();
					fila.desenfilheira();

					// Simula o tempo de lavagem para cada carro
					System.out.println("Lavando " + carro.toString());
					try {
						Thread.sleep(2500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					// Armazena os carros já lavados em uma lista
					Carro carrosAtendidos = carro;
					carrosLavados.insere(carrosAtendidos);

					cont++;
				}
				System.out.println("\nCarros Atendidos!\n");

				break;

			case 4:
				// Verifica se já foi lavado algum carro
				if (carrosLavados.estaVazia()) {
					System.out.println("Nenhum carro ainda foi lavado!\n");
				} else {
					// Mostra os carros já lavados
					System.out.println("CARROS LAVADOS:\n");
					carrosLavados.imprimeLista();
					System.out.println("");
					System.out.println(carrosLavados.getTamanho() + " Carros foram lavados!");

				}
				break;
			case 5:
				System.out.println("Programa Encerrado!");
				break;

			default:
				System.out.println("Opção Inválida!\n");
				break;
			}

		} while (opcao != 5);

	}

}
