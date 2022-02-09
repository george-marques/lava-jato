package model;

public class No<T> {
	
	private T dado;
	No<T> prox = null;

	public No(T dado) {
		this.dado = dado;
	}

	public T getDado() {
		return dado;
	}

	public void setDado(T dado) {
		this.dado = dado;
	}

	public No<T> getProx() {
		return prox;
	}

	public void setProx(No<T> prox) {
		this.prox = prox;
	}

}
