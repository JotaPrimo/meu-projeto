package br.com.dominio.model;

public enum TipoAtividade {

	APRESENTACAO("Apresentação"), CURSO("Curso"), MINICURSO("Minicurso"), PALESTRA("Palestra"), SEMINARIO("Palestra"),
	SIMPOSIO("Simposio"), OUTRA("Outra");

	private String descricao;

	TipoAtividade(String descricao) {
		this.descricao = descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
