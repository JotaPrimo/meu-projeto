package br.com.dominio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.dominio.model.Pessoa;

@Named("pessoaBean")
@ApplicationScoped
public class PessoaMB implements Serializable {	

	private static final long serialVersionUID = 1L;

	@Inject
	private Pessoa pessoa;
	
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public String adicionar() {
		
		pessoas.add(pessoa);
		
		// limpando a model de pessoa
		limpar(); 
		
		return "paginas/Sucesso";
	}
	
	public boolean isDisabled() {
		return false;
	}
	
	public boolean isRequired() {
		return true;
	}
	
	private void limpar() {
		pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	
}
