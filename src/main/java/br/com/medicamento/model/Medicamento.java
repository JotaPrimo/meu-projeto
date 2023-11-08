package br.com.medicamento.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Medicamento implements Serializable, Base {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nome;
	
	private String apresentacao;
	
	private String laboratorio;
	
	private BigDecimal preco;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
