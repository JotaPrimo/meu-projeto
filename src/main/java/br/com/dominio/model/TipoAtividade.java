package br.com.dominio.model;

import java.io.Serializable;
import java.util.Objects;

public class TipoAtividade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String descricao;	
		

	public TipoAtividade() {
		// TODO Auto-generated constructor stub
	}

	public TipoAtividade(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		TipoAtividade other = (TipoAtividade) obj;
		return Objects.equals(id, other.id);
	}
	
	
		
}
