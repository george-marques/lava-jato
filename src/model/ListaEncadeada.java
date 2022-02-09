package model;

public class ListaEncadeada<T> {
	
	private No<T> cabeca = null;
	private No<T> rabo = null;
	private int tamanho;

	public ListaEncadeada() {
		this.tamanho = 0;
	}

	public boolean estaVazia() {
		return this.tamanho == 0;
	}

	// Imprime os dados da lista
	public void imprimeLista() {
		for (No<T> temp = cabeca; temp != null; temp = temp.prox) {
			System.out.println(temp.getDado());
		}
	}
	
	public void remove(T valor) {
		No<T> anterior = null;
		No<T> atual = this.cabeca;

		for (int i = 0; i < getTamanho(); i++) {
			if (atual.getDado().equals(valor)) {
				if (tamanho == 1) {
					cabeca = null;
					rabo = null;
				} else if (atual == cabeca) {
					this.cabeca = atual.getProx();
					atual.setProx(null);
				} else if (atual == rabo) {
					this.rabo = anterior;
					anterior.setProx(null);
				} else {
					anterior.setProx(atual.getProx());
					atual = null;
				}
				this.tamanho--;
				break;

			}
			anterior = atual;
			atual = atual.getProx();
		}
	}

	public void insere(int posicao, T valor) {

		if (posicao < 0 || posicao > getTamanho()) {
			return;
		}

		No<T> novo = new No<T>(valor);

		if (posicao == 0) {
			novo.prox = cabeca;
			this.cabeca = novo;
			tamanho++;
			return;
		}

		if (posicao == getTamanho()) {
			setRabo(novo);
			tamanho++;

		}

		No<T> anterior = cabeca;

		// Percorre a lista até o elemento anterior a posicao da iserção
		for (int pos = 0; pos < posicao - 1; pos++, anterior = anterior.prox)
			;

		// Insere o novo elemento na lista
		// Verifica se a iserção é no rabo
		if (anterior.prox == null) {
			rabo = novo;
		}

		// Realiza inserção no novo NO
		novo.prox = anterior.prox;
		anterior.prox = novo;
		tamanho++;

	}

	// Insere um novo elemento na ultima posicao da lista
	public void insere(T dado) {
		// Cria o novo no que sera inserido na lista
		No<T> novo = new No<T>(dado);

		// A lista esta vazia?
		if (cabeca == null) {
			setCabeca(novo);
			tamanho++;
			return;
		}

		No<T> temp = null;

		for (temp = cabeca; temp.prox != null; temp = temp.prox)
			;

		temp.prox = novo;

		rabo = temp.prox;

		tamanho++;

	}

	public No<T> pegarPosicao(int posicao) {
		No<T> atual = this.cabeca;

		for (int i = 0; i < posicao; i++) {
			if (atual.getProx() != null) {
				atual = atual.getProx();
			}

		}

		return atual;
	}

	public No<T> getCabeca() {
		return cabeca;
	}

	public void setCabeca(No<T> cabeca) {
		this.cabeca = cabeca;
	}

	public No<T> getRabo() {
		return rabo;
	}

	public void setRabo(No<T> rabo) {
		this.rabo = rabo;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

}
