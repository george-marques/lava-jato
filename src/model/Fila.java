package model;

public class Fila<T> extends ListaEncadeada<T> {
	
	public void enfilheira(T elemento) {
		this.insere(elemento);
	}

	public void desenfilheira() {
		this.remove(this.get());
	}

	public T get() {
		return this.getCabeca().getDado();
	}

	public void imprimeFila(Fila<T> lista) {

		for (int i = 0; i < lista.getTamanho(); i++) {
			System.out.println(lista.pegarPosicao(i).getDado());

		}
	}

}
