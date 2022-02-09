package model;

public enum Cor {
	PRETO(1, "Preto"), 
	BRANCO(2, "Branco"), 
	CINZA(3, "Cinza"), 
	AMARELO(4, "Amarelo"), 
	AZUL(5, "Azul"),
	PRATA(6, "Prata");

	private Integer id;
	private String descricao;

	Cor(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;

	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Cor valueOf(int opcao) {
		for (Cor cor : Cor.values()) {
			if (cor.getId() == opcao)
				return cor;

		}

		return null;
	}
}
