package model;

import java.util.Scanner;

public class Carro {

	private String placa;
	private String marca;
	private String modelo;
	private String ano;
	private Cor cor;
	private static Scanner leitor = new Scanner(System.in);

	public Carro() {

	}

	public Carro(String placa, String marca, String modelo, String ano, Cor cor) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "Carro [Placa: " + placa + "| Marca: " + marca + " | Modelo: " + modelo + " | Ano: " + ano + " | Cor: "
				+ cor.getDescricao() + "]";
	}

	// Metódo para adicionar um novo carro na fila
	public static Carro cadastrarCarro() {
		Carro carro = new Carro();
		System.out.println("FICHA DO CARRO:");

		System.out.print("Informe a placa: ");
		carro.setPlaca(leitor.next());

		System.out.print("Informe a marca: ");
		carro.setMarca(leitor.next());

		System.out.print("Informe o modelo: ");
		carro.setModelo(leitor.next());

		System.out.print("Informe o ano: ");
		carro.setAno(leitor.next());

		System.out.println("Selecione uma cor:");

		for (Cor cores : Cor.values()) {
			System.out.println(cores.getId() + " - " + cores.getDescricao());
		}
		System.out.print("Informe a cor:");
		carro.setCor(Cor.valueOf(leitor.nextInt()));

		System.out.println("\n" + carro.toString() + " entrou na fila! \n");

		return carro;
	}

	// Base de dados, adicionei alguns carros na fila
	public static Fila<Carro> carrosCadastrados() {
		Fila<Carro> lista = new Fila<Carro>();

		lista.insere(new Carro("J4G25", "Chevrolet", "Celta", "2010", Cor.AZUL));
		lista.insere(new Carro("F2L10", "Ford", "Fusion", "2009", Cor.PRATA));
		lista.insere(new Carro("K7P41", "Hyundai", "Hb20", "2015", Cor.CINZA));
		lista.insere(new Carro("T1A33", "Toyota", "Corolla", "2019", Cor.PRETO));
		lista.insere(new Carro("I4U89", "Honda", "Civic", "2002", Cor.AMARELO));
		lista.insere(new Carro("L4B11", "Chevrolet", "Onix", "2019", Cor.BRANCO));
		lista.insere(new Carro("YBY22", "Renault", "Duster", "2015", Cor.CINZA));
		lista.insere(new Carro("ERY22", "Honda", "Fit", "2014", Cor.AZUL));
		lista.insere(new Carro("BHY22", "Renault", "Logan", "2006", Cor.PRATA));
		lista.insere(new Carro("GAO55", "Fiat", "Uno", "2007", Cor.PRETO));

		return lista;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
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

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

}
