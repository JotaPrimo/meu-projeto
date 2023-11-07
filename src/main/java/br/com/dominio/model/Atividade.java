package br.com.dominio.model;

import java.io.Serializable;
import java.util.Objects;

public class Atividade implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private TipoAtividade tipoAtividade;

	public Atividade() {
		// TODO Auto-generated constructor stub
	}

	public Atividade(String nome, TipoAtividade tipoAtividade) {
		super();
		this.nome = nome;
		this.tipoAtividade = tipoAtividade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoAtividade getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(TipoAtividade tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		return Objects.equals(id, other.id);
	}

}
